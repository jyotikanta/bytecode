package threading;

import neetcode.arrays.Hello;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            synchronized (lock1) {
                System.out.println("Hello from lock1 t1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Hello from lock2 t1");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Hello from lock2 t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Hello from lock2 t2");
                }
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task1 = () ->{
            synchronized (lock1){
                System.out.println("Hello from task1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("Hello task1");
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (lock2){
                System.out.println("Hello from task2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1){
                    System.out.println("Hello task2");
                }
            }
        };

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.shutdown();
        //t1.start();
        //t2.start();
    }
}
