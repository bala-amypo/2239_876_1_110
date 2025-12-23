package com.example.demo.exception;

/**
 * Custom runtime exception for validation failures such as
 * duplicates, missing required fields, or invalid numeric/time constraints.
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
