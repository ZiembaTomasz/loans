package com.ziembatomasz.loans.customer.service;

import com.ziembatomasz.loans.customer.domain.Customer;
import com.ziembatomasz.loans.customer.dto.CustomerDto;
import com.ziembatomasz.loans.customer.mapper.CustomerMapper;
import com.ziembatomasz.loans.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public List<CustomerDto> getCustomers(List<Integer> creditIds) {
        return customerMapper.mapToCustomerDtoList(customerRepository.findByCreditIdIn(creditIds));
    }

    public void createCustomer(CustomerDto customerDto) {
        Assert.notNull(customerDto.getPesel(), "Cannot create customer withour PESEL");
        Customer customer = customerMapper.mapToCustomer(customerDto);
        customerRepository.save(customer);
    }

    public CustomerDto findCustomerByPesel(String pesel) {
        CustomerDto customerDto = new CustomerDto();
        return customerDto = customerMapper.mapToCustomerDto(customerRepository.findByPesel(pesel));
    }
}
