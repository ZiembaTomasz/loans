package com.ziembatomasz.loans.product.repository;

import com.ziembatomasz.loans.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product>findByCreditIdIn(List<Integer>ids);
}
