package com.ziembatomasz.loans.customer.service;

import com.ziembatomasz.loans.customer.domain.Customer;
import com.ziembatomasz.loans.customer.dto.CustomerDto;

import com.ziembatomasz.loans.customer.mapper.CustomerMapper;
import com.ziembatomasz.loans.customer.repository.CustomerRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    CustomerService customerService;
    @Mock
    CustomerRepository customerRepository;
    CustomerMapper customerMapper = new CustomerMapper();

    @Before
    public void createCustomerServiceObject(){
        customerService = new CustomerService(customerRepository, customerMapper);
    }
    @Test
    public void shouldGetCustomersTest(){
        //Given
        List<Customer>customers = new ArrayList<>();
        Customer customer = new Customer("66150212345", "Andrzej", "Kowalski", 77);
        customers.add(customer);
        List<Integer> ids = new ArrayList<>();
        when(customerRepository.findByCreditIdIn(ids)).thenReturn(customers);
        //When
        List<CustomerDto>myCustomers = customerService.getCustomers(ids);
        //Then
        assertEquals(1, myCustomers.size());
    }
    @Test
    public void shouldCreateCustomerTest(){
        //Given
        Customer customer = new Customer("66150212345", "Andrzej", "Kowalski", 77);
        //When
        customerService.createCustomer(customerMapper.mapToCustomerDto(customer));
        //Then
        verify(customerRepository, times(1)).save(customer);
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowPeselNotFoundException(){
        //Given
        CustomerDto customerDto = new CustomerDto();
        //When
        customerService.createCustomer(customerDto);
    }
    @Test
    public void shouldGetCustomerByPeselTest(){
        //Given
        Customer customer = new Customer("66150212345", "Andrzej", "Kowalski", 77);;
        when(customerRepository.findByPesel("66150212345")).thenReturn(customer);
        //When
        CustomerDto myCustomerDto = customerService.findCustomerByPesel("66150212345");
        assertThat(myCustomerDto.getPesel()).isEqualTo(customer.getPesel());
    }
}