package com.ziembatomasz.loans.product.service;

import com.ziembatomasz.loans.product.domain.Product;
import com.ziembatomasz.loans.product.dto.ProductDto;
import com.ziembatomasz.loans.product.mapper.ProductMapper;
import com.ziembatomasz.loans.product.repository.ProductRepository;
import lombok.AllArgsConstructor;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Data
@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public List<ProductDto>getProducts(List<Integer>creditIds){
        return productMapper.mapToProductDto(productRepository.findByCreditIdIn(creditIds));
    }

    public void createProduct(ProductDto productDto){
        Product product = productMapper.mapToProduct(productDto);
        productRepository.save(product);
    }
}
