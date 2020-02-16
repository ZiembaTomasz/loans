package com.ziembatomasz.loans.credit.dto;

import com.ziembatomasz.loans.credit.domain.Credit;
import com.ziembatomasz.loans.customer.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanDto {
    private CreditDto creditDto;
    private CustomerDto customerDto;
}
