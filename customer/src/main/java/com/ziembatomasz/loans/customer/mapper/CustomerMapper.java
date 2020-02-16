package com.ziembatomasz.loans.customer.mapper;

import com.ziembatomasz.loans.customer.domain.Customer;
import com.ziembatomasz.loans.customer.dto.CustomerDto;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public List<CustomerDto> mapToCustomerDtoList(List<Customer> customerList) {
        return customerList.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    public CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(customer.getPesel(), customer.getFirstName(),
                customer.getSurname(), customer.getCreditId());
    }
    public Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(customerDto.getPesel(), customerDto.getFirstName(),
                customerDto.getSurname(), customerDto.getCreditId());
    }
}
