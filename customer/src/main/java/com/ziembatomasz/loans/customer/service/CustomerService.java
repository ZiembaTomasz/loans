package com.ziembatomasz.loans.customer.service;

import com.ziembatomasz.loans.customer.dto.CustomerDto;
import com.ziembatomasz.loans.customer.mapper.CustomerMapper;
import com.ziembatomasz.loans.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public List<CustomerDto> getCustomer() {
        return customerMapper.mapToCustomerDtoList(customerRepository.findAll());
    }
}
