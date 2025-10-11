package com.example.employeemanagement.model;

import com.example.employeemanagement.enums.EmploymentType;
import com.example.employeemanagement.model.dto.ContactDTO;

import java.time.LocalDate;
import java.util.List;

public record CreateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        LocalDate hireDate,
        LocalDate dateOfBirth,
        EmploymentType employmentType,
        Long departmentId,
        Long managerId,
        ContactDTO contact,
        String source,
        List<String> tags
) {
}
