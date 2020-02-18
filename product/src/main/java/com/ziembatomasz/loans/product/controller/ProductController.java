package com.ziembatomasz.loans.product.controller;

import com.ziembatomasz.loans.product.dto.ProductDto;
import com.ziembatomasz.loans.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam List<Integer>creditIds) {
        return productService.getProducts(creditIds);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
    }
}
