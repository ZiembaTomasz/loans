package com.ziembatomasz.loans.customer.service;

import com.ziembatomasz.loans.customer.domain.Customer;
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

    public List<CustomerDto> getCustomers() {
        return customerMapper.mapToCustomerDtoList(customerRepository.findAll());
    }
    public void createCustomer(CustomerDto customerDto){

        Customer customer = customerMapper.mapToCustomer(customerDto);
        customerRepository.save(customer);
    }
}
