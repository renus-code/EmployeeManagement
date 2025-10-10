package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.mapper.EmployeeDataMapper;
import com.example.employeemanagement.model.EmployeeData;
import com.example.employeemanagement.repository.EmployeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @NonNull
    private EmployeeRepository employeeRepository;
    private EmployeeDataMapper employeeDataMapper = Mappers.getMapper(EmployeeDataMapper.class);


    /**
     * @param employeeData
     * @return
     */
    @Override
    public ResponseEntity<EmployeeData> createEmployee(EmployeeData employeeData) {
        Employee employee = employeeDataMapper.employeeEntity(employeeData);
        employeeRepository.save(employee);
        return ResponseEntity.ok(employeeData);
    }

    /**
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
