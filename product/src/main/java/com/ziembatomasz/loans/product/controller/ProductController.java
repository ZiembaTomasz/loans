package com.ziembatomasz.loans.product.controller;

import com.ziembatomasz.loans.product.dto.ProductDto;
import com.ziembatomasz.loans.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ProductService productService;
    @GetMapping
    private List<ProductDto>getProducts(){
        return productService.getProducts();
    }
    @PostMapping
    private void createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
    }
}
