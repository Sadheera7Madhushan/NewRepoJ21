package com.example.demo.ExceptionHandlingExamples;

import com.example.demo.ExceptionHandlingExamples.Exceptions.ExceptionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
        return switch (ex) {
            case NullPointerException npe -> new ResponseEntity<>(new Error(2, ex.getMessage()), HttpStatus.OK);
            case IllegalArgumentException iae -> new ResponseEntity<>(new Error(3, ex.getMessage()), HttpStatus.OK);
            case ExceptionFailedException efe -> new ResponseEntity<>(new Error(4, ex.getMessage()), HttpStatus.OK);
            default -> new ResponseEntity<>(new Error(1, ex.getMessage()), HttpStatus.OK);
        };
    }
}

