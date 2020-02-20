package com.ziembatomasz.loans.credit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private CreditDto credit;
    private CustomerDto customer;
    private ProductDto product;
}
