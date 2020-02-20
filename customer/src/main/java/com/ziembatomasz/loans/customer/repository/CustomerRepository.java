package com.ziembatomasz.loans.customer.repository;

import com.ziembatomasz.loans.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByCreditIdIn(List<Integer> ids);

    Customer findByPesel(String pesel);
}

