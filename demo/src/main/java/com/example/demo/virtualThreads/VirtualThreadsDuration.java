package com.example.demo.virtualThreads;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadsDuration {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime(); // Start time for virtual threads

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) { // Virtual thread per task
            for (int i = 0; i < 100000; i++) {
                executor.submit(() -> {
                    // Simulate a task
                    System.out.println("Virtual Thread: is working..." );
                });
            }
        }

        long endTime = System.nanoTime(); // End time for virtual threads
        long durationInMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
        System.out.println("Duration with Virtual Threads: " + durationInMillis + " ms");
    }
}
