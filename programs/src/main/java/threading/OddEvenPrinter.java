package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenPrinter {

    private final int max;
    private volatile boolean isOdd;

    public OddEvenPrinter(int max) {
        this.max = max;
        this.isOdd = true;
    }

    public void printOdd() {
        synchronized (this) {
            for (int i = 1; i <= max; i += 2) {
                while (!isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Odd: " + i);
                isOdd = false;
                notify();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            for (int i = 2; i <= max; i += 2) {
                while (isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Even: " + i);
                isOdd = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(10);

        Runnable printOddTask = printer::printOdd;
        Runnable printEvenTask = printer::printEven;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(printOddTask);
        executorService.submit(printEvenTask);

        executorService.shutdown();
    }
}

