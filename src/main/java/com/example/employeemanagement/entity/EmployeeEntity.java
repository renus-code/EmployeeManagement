package com.example.employeemanagement.entity;

import com.example.employeemanagement.enums.EmploymentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeNumber; // e.g., E-2025-000123
    private String firstName;
    private String lastName;
    private String emailID;
    private LocalDate dateOfBirth;
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;
    private Long departmentId;
    private Long managerId;
    private String phone;
    private String addressLine1;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String status; // e.g., PENDING_VERIFICATION, ACTIVE

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;
}
