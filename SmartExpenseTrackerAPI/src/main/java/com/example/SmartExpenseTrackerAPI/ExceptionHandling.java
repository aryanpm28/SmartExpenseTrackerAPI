package com.example.SmartExpenseTrackerAPI;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Handles exceptions globally
@RestControllerAdvice
public class ExceptionHandling {

    // Handles all exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntime(RuntimeException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());

         // Returns custom error message
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}