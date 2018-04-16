import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.support.v4.content.LocalBroadcastManager;

public class NotificationHandler extends JobIntentService
{
    static final String TAG = "NotificationHandler";
    static final int JOB_ID = 101;
    private static Map<String,Intent> action_intent_map;
    private static Map<String,String> action_clientUri_map;
    protected DMCommandHandlerFactory commandHandlerFactory;
    private String callBackHandlerName = null;
    
    public static void enqueueWork(Context context, Intent intent)
    {
        enqueueWork(context, NotificationHandler.class, JOB_ID, intent);
    }
    
    public NotificationHandler()
    {
        super();
        commandHandlerFactory = DMCommandHandlerFactory.getInstance();
    }
    
    public NotificationHandler(String callBackHandlerName)
    {
        super();
        commandHandlerFactory = DMCommandHandlerFactory.getInstance();
        this.callBackHandlerName = callBackHandlerName;
    }
    
    @Override
    protected void onHandleWork(@NonNull Intent intent)
    {
        ZENLogger.debug(TAG, "Processing notification");
        
        // Step 1: Perform sync if sufficient information is not available. There is no harm in doing a sync :)
        if(intent == null)
        {
            ZENLogger.debug(TAG, "Intent received in notification is null. Performing a sync with no call back handler.");
            SyncManager.getInstance().performSync(null);
            return;
        }
        
        // Step 2: Check whether the intent is gcm intent.
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        String messageType = gcm.getMessageType(intent);
        
        if(messageType == null)
        {
            ZENLogger.debug(TAG, "Intent received is not a gcm intent");
            return;
        }
        
        ZENLogger.debug(TAG, "Notification with type {0} received", messageType);
        
        
        Bundle extras = intent.getExtras();
        if(extras == null || extras.isEmpty())
        {
            ZENLogger.debug(TAG, "Intent do not have sufficient information. Performing a sync with no call back handler.");
            SyncManager.getInstance().performSync(null);
            return;
        }
        //TODO
        if(Boolean.valueOf(String.valueOf(intent.getExtras().get("gcm.notification.isfirebase"))))
        {
            handleFCMPayload(intent);
        }
        else
        {
            handleGCMPayload(intent);
        }
        
    }
    
    
    private void handleFCMPayload(Intent intent)
    {
        String payloadString = intent.getExtras().getString("gcm.notification.payload");
        if(payloadString == null || payloadString.isEmpty())
        {
            ZENLogger.debug(TAG, "Payload received in notification is null. Performing a sync with no call back handler.");
            SyncManager.getInstance().performSync(null);
            return;
        }
        
        // Step 4: Information is available in the notification.
        ObjectMapper mapper = new ObjectMapper();
        PushNotificationPayLoad payload = null;
        try
        {
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            payload = mapper.readValue(payloadString, PushNotificationPayLoad.class);
        }
        catch(JsonParseException e)
        {
            ZENLogger.debug(TAG, "Exception while parsing JSON {0}", e, payloadString);
        }
        catch(JsonMappingException e)
        {
            ZENLogger.debug(TAG, "Exception while parsing JSON {0}", e, payloadString);
        }
        catch(IOException e)
        {
            ZENLogger.debug(TAG, "Exception while parsing JSON {0}", e, payloadString);
        }
        
        if(payload != null)
        {
            processPayloadInformation(intent, payload);
        }
        else
        {
            SyncManager.getInstance().performSync(null);
        }
        
    }
    
    
    private void handleGCMPayload(Intent intent)
    {
        // Step 3: Again, perform sync if sufficient payload information is not available.
        String payloadString = intent.getExtras().getString(MobileCoreConstants.PAYLOAD_STRING);
        if(payloadString == null || payloadString.isEmpty())
        {
            ZENLogger.debug(TAG, "Payload received in notification is null. Performing a sync with no call back handler.");
            SyncManager.getInstance().performSync(null);
            return;
        }
        
        // Step 4: Information is available in the notification.
        ObjectMapper mapper = new ObjectMapper();
        PushNotificationPayLoad payload = null;
        try
        {
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            payload = mapper.readValue(payloadString, PushNotificationPayLoad.class);
        }
        catch(JsonParseException e)
        {
            ZENLogger.debug(TAG, "Exception while parsing JSON {0}", e, payloadString);
        }
        catch(JsonMappingException e)
        {
            ZENLogger.debug(TAG, "Exception while parsing JSON {0}", e, payloadString);
        }
        catch(IOException e)
        {
            ZENLogger.debug(TAG, "Exception while parsing JSON {0}", e, payloadString);
        }
        
        if(payload != null)
        {
            processPayloadInformation(intent, payload);
        }
    }
    
    private void processPayloadInformation(Intent intent, PushNotificationPayLoad payload)
    {
        String notificationTimeString = payload.getTimeStamp();
        String enrollmentTimeString = ConfigManager.getInstance().retrieveString(Constants.DEVICE_ENROLLEMNT_TIME, "");
        
        // Bug 1050079 changes
        if(notificationTimeString == null || notificationTimeString.isEmpty() ||
                enrollmentTimeString == null || enrollmentTimeString.isEmpty())
        {
            ZENLogger.debug(TAG, "notificationTimeStamp or enrollmentTime field is not received");
        }
        else
        {
            try
            {
                Date notificationTime = new SimpleDateFormat(Constants.QUICKTASK_DATE_FORMAT).parse(notificationTimeString);
                Date enrollmentTime = new SimpleDateFormat(Constants.QUICKTASK_DATE_FORMAT).parse(enrollmentTimeString);
                
                // Step 4a: If a notification with time stamp before enrollment time is received, it is a invalid notification. Ignore it.
                if(notificationTime.compareTo(enrollmentTime) < 0)
                {
                    ZENLogger.debug(TAG, "Timestamp on the notification received is before device enrollment time.");
                    return;
                }
            }
            catch(ParseException e)
            {
                ZENLogger.debug(TAG, "Exception while parsing {0} {1}", e, notificationTimeString, enrollmentTimeString);
                return;
            }
        }
        
        HashMap<String,String> addInfo = payload.getAdditionalInfo();

        /*
         * Checking If additional info contains force sync flag
         * than perform sync with the force sync as true
         */
        boolean forceSync = false;
        if(addInfo != null && addInfo.containsKey(MobileCoreConstants.FORCE_SYNC))
        {
            forceSync = Boolean.valueOf(addInfo.get(MobileCoreConstants.FORCE_SYNC));
        }
        
        // Step 4b: If action type is not available, perform a sync with no call back.
        String actionType = payload.getAction_type();
        
        //TODO ask for available action types and additional info.
        if(actionType == null || actionType.isEmpty())
        {
            ZENLogger.debug(TAG, "Action type received in notification is null. Performing a sync with no call back handler.");
            SyncManager.getInstance().performSync(payload.getSyncType(), forceSync, null);
            return;
        }
        
        //to handle compliance message notification(device side only/ no doPost call required)
        if(MobileCoreConstants.ACTION_TYPE_ZMM_NOTIFICATION_MESSAGE.equals(actionType))
        {
            ZENLogger.debug(TAG, "notification received with message :{0}", payload.getAdditionalInfo().get(MobileCoreConstants.SEND_MESSAGE_TEXT));
            
            MobileNotificationUtil notificationUtil = new MobileNotificationUtil.MobileNotificationBuilder()
                    .setTitle(payload.getAdditionalInfo().get(MobileCoreConstants.SEND_MESSAGE_SUBJECT)).setDescription(payload.getAdditionalInfo().get(MobileCoreConstants.SEND_MESSAGE_TEXT)).setIntent(new Intent())
                    .setNotificationID((int)System.currentTimeMillis())
                    .setLockScreenVisibility(Notification.VISIBILITY_PRIVATE)
                    .setVibrationReq(true).setNotificationSoundReq(true).setAutoCancel(false)
                    .build();
            
            notificationUtil.createNotification();
            return;
        }
        // Step 4c: If client uri is not available, then perform a sync with no call back handler as we can not perform any action when client uri is not available.
        
        //Verify if any additional information is available
        if(addInfo.containsKey((MobileCoreConstants.EXTRA_DATA_STRING)))
        {
            String extraString = addInfo.get(MobileCoreConstants.EXTRA_DATA_STRING);
            
            // Convert unenroll action to full wipe action if the administrator chosen option is "full wipe", instead of "selective wipe"
            
            if(extraString != null && extraString.equals(MobileCoreConstants.ACTION_TYPE_ZMM_FULLWIPE))
                actionType = extraString;
            
        }
        
        String clientURI = addInfo.get(MobileCoreConstants.CLIENT_URI_STRING);
        if(clientURI == null || clientURI.isEmpty())
        {
            ZENLogger.debug(TAG, "Client uri received in notification is null. Performing a sync with no call back handler.");
            SyncManager.getInstance().performSync(payload.getSyncType(), forceSync, null);
            return;
        }
        ZENLogger.debug(TAG, "client uri of the action received via notification is {0}", clientURI);
        
        // Step 4c: Gather information that will be used in the call back method - updateStatusAfterSync
        if(action_intent_map == null)
            action_intent_map = new HashMap<String,Intent>();
        if(action_clientUri_map == null)
            action_clientUri_map = new HashMap<String,String>();
        
        action_intent_map.put(actionType, intent);
        action_clientUri_map.put(actionType, clientURI);
        final String callBackHandlerName = actionType;
        
        // Step 5: perform sync
        SyncManager.getInstance().performSync(payload.getSyncType(), forceSync, new SyncCallBackHandler(null)
        {
            @Override
            public void updateScanAFEStatus(StatusCode statusCode)
            {
                if(statusCode != StatusCode.ANDROID_ENTERPRISE_ASSIGNED)
                    updateStatusAfterSync(statusCode, getName());
            }
    
    
            @Override
            public void updateStatus(StatusCode statusCode)
            {
                updateStatusAfterSync(statusCode, getName());
            }
            
            @Override
            public String getName()
            {
                return callBackHandlerName;
            }
        });
        
    }
    
    public void updateStatusAfterSync(StatusCode statusCode, String actionType)
    {
        ZENLogger.debug(TAG, "Sync finished with status code : {0}", statusCode.toString());
        
        // Step 6: If performAlert has succeeded, no action needs to be performed. Wake lock needs to be released.
        Intent processingIntent = null;
        
        // If required information is not available, then return
        if(actionType == null || actionType.isEmpty() || action_intent_map == null)
            return;
        
        // retrieve intent. If intent not available, implies no payload and hence no client uri. Return.
        processingIntent = action_intent_map.get(actionType);
        if(processingIntent == null)
            return;
        action_intent_map.remove(actionType);
        
        PushNotificationPayLoad payload = null;
        if(processingIntent.getExtras() != null)
        {
            String payloadString = processingIntent.getExtras().getString(MobileCoreConstants.PAYLOAD_STRING);
            
            if(payloadString != null && !payloadString.isEmpty())
            {
                ObjectMapper mapper = new ObjectMapper();
                payload = null;
                try
                {
                    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    
                    payload = mapper.readValue(payloadString, PushNotificationPayLoad.class);
                }
                catch(IOException e)
                {
                    ZENLogger.debug(TAG, "Exception while parsing {0}", e, payloadString);
                }
            }
        }
        
        // retrieve client uri
        String clientURI = (action_clientUri_map != null) ? action_clientUri_map.get(actionType) : null;
        if(action_clientUri_map.containsKey(actionType))
            action_clientUri_map.remove(actionType);
        
        // Release the wake lock provided by the WakefulBroadcastReceiver on sync success or if client uri is not available
        if(statusCode == StatusCode.SUCCESS || clientURI == null || clientURI.isEmpty())
        {
            return;
        }
        
        // Step 7: If perform alert has not succeeded, call respective handler represented by clientURI to perform the action.
        IDMCommandHandler dmCommandHandler = commandHandlerFactory.createDMCommandHandler(clientURI);
        StatusCode performActionStatusCode = StatusCode.SUCCESS;
        if(dmCommandHandler != null)
        {
            performActionStatusCode = dmCommandHandler.performAction(actionType, payload);
        }
    
        if((statusCode == ANDROID_ENTERPRISE_POLICY_NOT_ASSIGNED || statusCode == APP_CANNOT_BE_MANAGED) && !(actionType.equals
                (MobileCoreConstants
                        .ACTION_TYPE_ZMM_UNENROLL) || actionType.equals(MobileCoreConstants.ACTION_TYPE_ZMM_FULLWIPE)))
        {
            EnterpriseUtil.handleDefaultError(APP_CANNOT_BE_MANAGED, null);
        }
    }
}
