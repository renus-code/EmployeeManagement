package com.example.employeemanagement.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {
    private String message;

    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
