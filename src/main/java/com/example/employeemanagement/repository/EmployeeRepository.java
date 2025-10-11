package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    boolean existsByEmailID(String emailID);

}
