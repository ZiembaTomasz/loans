package com.ziembatomasz.loans.credit.service;

import com.ziembatomasz.loans.credit.client.CustomerClient;
import com.ziembatomasz.loans.credit.dto.LoanDto;

public class LoanService {
    private CreditService creditService;
    private CustomerClient customerClient;
    public void createLoan(LoanDto loanDto){
        creditService.createCredit(loanDto.getCreditDto());
        customerClient.createCustomer(loanDto.getCustomerDto());
    }
}
