package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

    // Default constructor
    public ResourceNotFoundException() {
        super();
    }

    // Constructor with custom message
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with cause
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
