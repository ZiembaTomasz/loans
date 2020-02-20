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
    public List<CustomerDto> getCustomers(@RequestParam List<Integer> creditIds) {
        return customerService.getCustomers(creditIds);
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
    }

    @GetMapping(value = "getCustomerByPesel")
    public CustomerDto getCustomer(@RequestParam String pesel) {
        return customerService.findCustomerByPesel(pesel);
    }
}
