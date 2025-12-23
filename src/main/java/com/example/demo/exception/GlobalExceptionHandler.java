package com.example.demo.exception;

import com.example.demo.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ApiResponse.error(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    // Handle allocation issues
    @ExceptionHandler(AllocationException.class)
    public ResponseEntity<ApiResponse<Object>> handleAllocationException(AllocationException ex) {
        return new ResponseEntity<>(ApiResponse.error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // Handle duplicate user/email
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return new ResponseEntity<>(ApiResponse.error(ex.getMessage()), HttpStatus.CONFLICT);
    }

    // Handle general validation errors
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Object>> handleIllegalArgument(IllegalArgumentException ex) {
        return new ResponseEntity<>(ApiResponse.error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(ApiResponse.error("Internal server error: " + ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
