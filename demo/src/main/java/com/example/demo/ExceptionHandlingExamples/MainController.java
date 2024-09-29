package com.example.demo.ExceptionHandlingExamples;

import com.example.demo.ExceptionHandlingExamples.Exceptions.ExceptionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Main controller.
 */
@RestController
public class MainController {

    /**
     * Method 1 response entity.
     *
     * @return the response entity
     */
    @RequestMapping("/method1")
    public ResponseEntity<String> method1() {

        String data = "abc";
        if (data != "xyz") {
            throw new ExceptionFailedException("Failed to execute: data is null");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Method 12 response entity.
     *
     * @return the response entity
     */
    @RequestMapping("/method2")
    public ResponseEntity<String> method12() {

        String str = null;
        int length = str.length();
        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(length));
    }
}
