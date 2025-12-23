package com.example.demo.exception;

/**
 * Custom runtime exception thrown when a requested entity is not found.
 * Used for User, Resource, ResourceRequest, ResourceAllocation, AllocationRule, etc.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
