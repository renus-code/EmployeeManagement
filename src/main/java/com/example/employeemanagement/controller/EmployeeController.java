package com.example.employeemanagement.controller;

import com.example.employeemanagement.exception.EmployeeAlreadyExistsException;
import com.example.employeemanagement.exception.ErrorResponse;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.model.CreateEmployeeRequest;
import com.example.employeemanagement.model.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {
    private static final String REQ_URL = "/api/v1/emp/";

    @NonNull
    private final EmployeeService employeeService;

    @PostMapping(REQ_URL)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest employeeRequest) {
        EmployeeResponse response = employeeService.createEmployee(employeeRequest);
        URI location = URI.create(REQ_URL + response.id());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping(REQ_URL)
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(REQ_URL + "{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        EmployeeResponse response = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(response);
    }

    // Exception Handler to handle EmployeeAlreadyExistsException for this controller
    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.toString());
    }

    // Handle Not Found cases
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.toString());
    }
}
