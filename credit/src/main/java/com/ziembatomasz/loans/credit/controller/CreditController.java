package com.ziembatomasz.loans.credit.controller;

import com.ziembatomasz.loans.credit.dto.CreditDto;
import com.ziembatomasz.loans.credit.dto.LoanDto;
import com.ziembatomasz.loans.credit.service.CreditService;
import com.ziembatomasz.loans.credit.service.LoanService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/credit")
public class CreditController {
    private CreditService creditService;
    private LoanService loanService;
    public void createCredit(@RequestBody LoanDto loanDto){
        loanService.createLoan(loanDto);
    }
    public List<CreditDto>getCredits(){
        return creditService.getCredits();
    }
}
