package threading;

import java.util.ArrayList;

public class PrintOddEven {
    public static boolean flag = true;
    synchronized public void printOdd(int i) {
        while(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(i);
        flag=false;
        notify();
    }
    synchronized public void printEven(int i) {
        while(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(i);
        flag=true;
        notify();
    }
    public static void main(String[] args) {
        PrintOddEven p = new PrintOddEven();
        Thread oddThread = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i=1;i<100;i+=2){
                    p.printOdd(i);
                }
            }
        });

        Thread evenThread = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i=2;i<100;i+=2){
                    p.printEven(i);
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
