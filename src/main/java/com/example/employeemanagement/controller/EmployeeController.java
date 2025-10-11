package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.CreateEmployeeRequest;
import com.example.employeemanagement.model.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class EmployeeController {
    private final String REQ_URL = "/api/v1/emp/";

    @NonNull
    private final EmployeeService employeeService;

    @PostMapping(REQ_URL)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest employeeRequest) {
        EmployeeResponse response = employeeService.createEmployee(employeeRequest);
        URI location = URI.create(REQ_URL + response.id());
        return ResponseEntity.created(location).body(response);
    }

//    @GetMapping(REQ_URL)
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }

}
