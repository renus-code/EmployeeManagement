package com.example.employeemanagement.model.dto;

import lombok.Builder;

@Builder
public record ContactDTO(String phoneNumber, AddressDTO address) {
}
