package com.example.demo.ExceptionHandlingExamples;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private int errorCode;
    private String errorMessage;
}
