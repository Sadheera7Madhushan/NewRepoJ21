package com.example.demo.virtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TraditionalThreadsDuration {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime(); // Start time for traditional threads

        ExecutorService executor = Executors.newFixedThreadPool(1); // Fixed pool of 10 threads
        for (int i = 0; i < 1000000; i++) {
            executor.submit(() -> {
                // Simulate a task
                System.out.println("Traditional Thread: is working..." );
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES); // Wait for all tasks to finish

        long endTime = System.nanoTime(); // End time for traditional threads
        long durationInMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
        System.out.println("Duration with Traditional Threads: " + durationInMillis + " ms");
    }
}
