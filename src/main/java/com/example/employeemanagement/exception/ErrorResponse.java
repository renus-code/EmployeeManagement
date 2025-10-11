package com.example.employeemanagement.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String message;
    private final String statusCode;

    public ErrorResponse(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
