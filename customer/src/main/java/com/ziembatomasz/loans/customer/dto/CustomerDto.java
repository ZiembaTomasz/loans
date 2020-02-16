package com.ziembatomasz.loans.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {
    private String pesel;
    private String firstName;
    private String surname;
    private int creditId;
}
