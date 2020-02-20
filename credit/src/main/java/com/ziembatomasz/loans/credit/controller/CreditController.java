package com.ziembatomasz.loans.credit.controller;

import com.ziembatomasz.loans.credit.dto.LoanDto;
import com.ziembatomasz.loans.credit.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/credit")
@AllArgsConstructor
public class CreditController {
    private LoanService loanService;

    @PostMapping
    public void createCredit(@RequestBody LoanDto loanDto) {
        loanService.createLoan(loanDto);
    }

    @GetMapping
    public List<LoanDto> getCredits() {
        return loanService.getLoan();
    }
}
