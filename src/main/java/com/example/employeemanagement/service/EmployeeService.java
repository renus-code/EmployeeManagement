package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.model.EmployeeData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<EmployeeData> createEmployee(EmployeeData employee);

    List<Employee> getAllEmployees();
}
