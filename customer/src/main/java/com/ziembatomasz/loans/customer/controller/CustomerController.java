package com.ziembatomasz.loans.customer.controller;

import com.ziembatomasz.loans.customer.dto.CustomerDto;
import com.ziembatomasz.loans.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }
    @PostMapping
    public void createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
    }
}
