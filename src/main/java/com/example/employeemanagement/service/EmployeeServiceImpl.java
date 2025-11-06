package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.EmployeeEntity;
import com.example.employeemanagement.exception.EmployeeAlreadyExistsException;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.mapper.EmployeeDataMapper;
import com.example.employeemanagement.model.CreateEmployeeRequest;
import com.example.employeemanagement.model.EmployeeResponse;
import com.example.employeemanagement.repository.EmployeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @NonNull
    private EmployeeRepository employeeRepository;
    private final EmployeeDataMapper employeeDataMapper = Mappers.getMapper(EmployeeDataMapper.class);


    /**
     * @param employeeRequest
     * @return
     */
    @Override
    public EmployeeResponse createEmployee(CreateEmployeeRequest employeeRequest) {
        String email = employeeRequest.email().trim().toLowerCase();
        if (employeeRepository.existsByEmailID(email)) {
            throw new EmployeeAlreadyExistsException("Email ID already exists : " + email);
        }

        EmployeeEntity employeeEntity = employeeDataMapper.toEmployeeEntity(employeeRequest);
        employeeEntity.setEmailID(email);
        employeeEntity.setEmployeeNumber(generateEmployeeNumber());

        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);

        return employeeDataMapper.toResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeDataMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        EmployeeEntity entity = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
        return employeeDataMapper.toResponse(entity);
    }

    /**
     * @return
     */
//    @Override
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
    private String generateEmployeeNumber() {
        return "E-" + java.time.Year.now() + "-" + String.format("%06d", System.nanoTime() % 1_000_000);
    }
}
