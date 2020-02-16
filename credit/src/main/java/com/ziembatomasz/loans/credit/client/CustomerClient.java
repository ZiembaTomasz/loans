package com.ziembatomasz.loans.credit.client;

import com.ziembatomasz.loans.customer.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CustomerClient {
    RestTemplate restTemplate = new RestTemplate();

    public void createCustomer(CustomerDto customerDto) {
        String fooResourceUrl = "http://localhost:8081/customer";
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, customerDto, String.class);
    }
}
