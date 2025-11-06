package com.example.employeemanagement.mapper;


import com.example.employeemanagement.entity.EmployeeEntity;
import com.example.employeemanagement.model.CreateEmployeeRequest;
import com.example.employeemanagement.model.EmployeeResponse;
import com.example.employeemanagement.model.dto.AddressDTO;
import com.example.employeemanagement.model.dto.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeDataMapper {

    @Mapping(source = "email", target = "emailID")
    @Mapping(source = "employmentType", target = "employmentType")
    @Mapping(source = "contact.phoneNumber", target = "phone")
    @Mapping(source = "contact.address.line1", target = "addressLine1")
    @Mapping(source = "contact.address.city", target = "city")
    @Mapping(source = "contact.address.state", target = "state")
    @Mapping(source = "contact.address.postalCode", target = "postalCode")
    @Mapping(source = "contact.address.country", target = "country")
    @Mapping(target = "status", constant = "PENDING_VERIFICATION")
    @Mapping(target = "employeeNumber", ignore = true)
    EmployeeEntity toEmployeeEntity(CreateEmployeeRequest empRequest);


    @Mapping(source = "emailID", target = "email")
    @Mapping(target = "id", expression = "java(employee.getId() != null ? String.valueOf(employee.getId()) : null)")
    @Mapping(target = "contact", expression = "java(mapContact(employee))")
    EmployeeResponse toResponse(EmployeeEntity employee);


    default ContactDTO mapContact(EmployeeEntity entity) {

        AddressDTO address = AddressDTO.builder()
                .line1(entity.getAddressLine1())
                .city(entity.getCity())
                .state(entity.getState())
                .postalCode(entity.getPostalCode())
                .country(entity.getCountry())
                .build();

        return ContactDTO.builder()
                .phoneNumber(entity.getPhone())
                .address(address)
                .build();
    }

}