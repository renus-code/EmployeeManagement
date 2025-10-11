package com.example.employeemanagement.model;

import com.example.employeemanagement.enums.EmploymentType;
import com.example.employeemanagement.model.dto.ContactDTO;

import java.time.Instant;
import java.time.LocalDate;

public record EmployeeResponse(
        String id,
        String employeeNumber,
        String status,
        String firstName,
        String lastName,
        String email,
        LocalDate hireDate,
        EmploymentType employmentType,
        Long departmentId,
        Long managerId,
        ContactDTO contact,
        Instant createdAt
) {
}
