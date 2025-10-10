package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.model.EmployeeData;
import com.example.employeemanagement.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {
    private final String REQ_URL = "/api/v1/emp/";

    @NonNull
    private final EmployeeService employeeService;

    @PostMapping(REQ_URL)
    public ResponseEntity<EmployeeData> createEmployee(@RequestBody EmployeeData employeeData) {
        return employeeService.createEmployee(employeeData);
    }

    @GetMapping(REQ_URL)
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
