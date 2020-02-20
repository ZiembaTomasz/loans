package com.ziembatomasz.loans.product.service;

import com.ziembatomasz.loans.product.domain.Product;
import com.ziembatomasz.loans.product.dto.ProductDto;
import com.ziembatomasz.loans.product.mapper.ProductMapper;
import com.ziembatomasz.loans.product.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;
    ProductService productService;
    ProductMapper productMapper = new ProductMapper();

    @Before
    public void createProductServiceObject() {
        productService = new ProductService(productRepository, productMapper);
    }

    @Test
    public void shouldGetProductsTest() {
        //Given
        List<Product> products = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        Product product = new Product("Good Credit", 20000, 7);
        products.add(product);
        when(productRepository.findByCreditIdIn(ids)).thenReturn(products);
        //When
        List<ProductDto> myProducts = productService.getProducts(ids);
        //Then
        assertEquals(1, myProducts.size());
    }

    @Test
    public void shouldCreateProductTest() {
        //Given
        Product product = new Product("Good Credit", 20000, 7);
        //When
        productService.createProduct(productMapper.mapToProductDto(product));
        //Then
        verify(productRepository, times(1)).save(product);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {
        //Given
        ProductDto productDto = new ProductDto();
        //When
        productService.createProduct(productDto);
    }
}