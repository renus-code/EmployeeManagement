package com.example.employeemanagement.service;

import com.example.employeemanagement.model.CreateEmployeeRequest;
import com.example.employeemanagement.model.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse createEmployee(CreateEmployeeRequest employeeRequest);

//    List<Employee> getAllEmployees();
}
