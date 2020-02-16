package com.ziembatomasz.loans.customer.repository;


import com.ziembatomasz.loans.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

