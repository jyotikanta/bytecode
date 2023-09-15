package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafetyExample {
    public static void main(String[] args) {
        // Create a shared StringBuilder
        StringBuilder sharedBuilder = new StringBuilder();

        // Create an ExecutorService with multiple threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long st = System.currentTimeMillis();
        // Using AtomicInteger to track the progress of each thread
        AtomicInteger thread1Progress = new AtomicInteger(0);
        AtomicInteger thread2Progress = new AtomicInteger(0);

        // Submit two tasks that append to the sharedBuilder concurrently
        executorService.submit(() -> {
            while (thread1Progress.getAndIncrement() < 1000) {
                sharedBuilder.append("A");
            }
        });

        executorService.submit(() -> {
            while (thread2Progress.getAndIncrement() < 1000) {
                sharedBuilder.append("B");
            }
        });

        // Shutdown the executor
        executorService.shutdown();

        // Wait for both tasks to complete
        while (!executorService.isTerminated()) {
            // Waiting
        }

        // Print the final result
        System.out.println("Final Result: " + sharedBuilder.toString());
        System.out.println("Total time taken " + (System.currentTimeMillis() - st) + "ms");
    }
}
