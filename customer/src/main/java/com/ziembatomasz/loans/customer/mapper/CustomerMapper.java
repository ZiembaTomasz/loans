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
                .map(this::mapToCustomer)
                .collect(Collectors.toList());
    }

    public CustomerDto mapToCustomer(Customer customer) {
        return new CustomerDto(customer.getPesel(), customer.getFirstName(),
                customer.getSurname(), customer.getCreditId());
    }
}
