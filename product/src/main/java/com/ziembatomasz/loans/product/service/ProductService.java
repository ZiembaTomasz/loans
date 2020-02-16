package com.ziembatomasz.loans.product.service;

import com.ziembatomasz.loans.product.domain.Product;
import com.ziembatomasz.loans.product.dto.ProductDto;
import com.ziembatomasz.loans.product.mapper.ProductMapper;
import com.ziembatomasz.loans.product.repository.ProductRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public List<ProductDto>getProducts(){
        return productMapper.mapToProductDto(productRepository.findAll());
    }

    public void createProduct(ProductDto productDto){
        Product product = productMapper.mapToProduct(productDto);
        productRepository.save(product);
    }
}
