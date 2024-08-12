package threading;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MySingleton {
    private static volatile MySingleton instance;
    private MySingleton(){
    }

    public static MySingleton getInstance(){
        if(instance==null){
            synchronized(MySingleton.class){
                if(instance==null){
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }

    public Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
