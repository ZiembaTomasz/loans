package com.ziembatomasz.loans.credit.client;

import com.ziembatomasz.loans.credit.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductClient {
    RestTemplate restTemplate = new RestTemplate();

    public void createProduct(ProductDto productDto){
        String fooResourceUrl = "http://product:8082/product";
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, productDto, String.class);
    }
    public List<ProductDto>getProducts(List<Integer>creditIds){
        String creditIdsString= creditIds.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        String fooResourceUrl = "http://product:8082/product" + creditIdsString;
        ResponseEntity<ProductDto[]> response = restTemplate.getForEntity(fooResourceUrl, ProductDto[].class);

        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
