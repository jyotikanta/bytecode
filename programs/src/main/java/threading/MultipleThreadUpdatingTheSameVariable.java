package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultipleThreadUpdatingTheSameVariable {
    public static int x=0;
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                incrementX();
//            }
//        });Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                incrementX();
//            }
//        });Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                incrementX();
//            }
//        });Thread t4 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                incrementX();
//            }
//        });
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        Thread.sleep(1000);
//        System.out.println(x);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            executor.submit(MultipleThreadUpdatingTheSameVariable::incrementX);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(x);
    }

    public static void incrementX(){
        for (int i=0;i<10;i++){
           synchronized (MultipleThreadUpdatingTheSameVariable.class){
                System.out.println(Thread.currentThread().getName() + " : " + x++);
           }
            //System.out.println(Thread.currentThread().getName() + " : " + x++);
        }
    }

}
