package com.ziembatomasz.loans.product.mapper;

import com.ziembatomasz.loans.product.domain.Product;
import com.ziembatomasz.loans.product.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Component
public class ProductMapper {
     public Product mapToProduct(ProductDto productDto){
        return new Product(productDto.getProductName(), productDto.getValue(), productDto.getCreditId());
    }
    public ProductDto mapToProductDto(Product product){
        return new ProductDto(product.getProductName(), product.getValue(), product.getCreditId());
    }
    public List<ProductDto> mapToProductDto(List<Product>products){
        return products.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
