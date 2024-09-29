package com.example.demo.testing;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("hello", "world", "method", "references");
        // Convert and print uppercase words using method reference
        words.stream()
                .map(String::toUpperCase)
                .filter(x->x.contains("L"))// Convert each string to uppercase
                .forEach(System.out::println); // Print each uppercase string

    }
}
