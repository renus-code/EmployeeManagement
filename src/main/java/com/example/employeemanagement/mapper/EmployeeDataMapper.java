package com.example.employeemanagement.mapper;


import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.model.EmployeeData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeDataMapper {
    @Mapping(source = "surName", target = "lastName")
    @Mapping(source = "emailAddress", target = "emailID")
    Employee employeeEntity(EmployeeData employeeData);
}