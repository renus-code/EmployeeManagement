package com.example.employeemanagement.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record AddressDTO(
        String line1,
        String city,
        String state,
        String postalCode,
        String country
) {
}
