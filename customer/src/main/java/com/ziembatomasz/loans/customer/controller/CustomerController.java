package com.ziembatomasz.loans.customer.controller;

import com.ziembatomasz.loans.customer.dto.CustomerDto;
import com.ziembatomasz.loans.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    private List<CustomerDto> getCustomers() {
        return customerService.getCustomer();
    }
}
