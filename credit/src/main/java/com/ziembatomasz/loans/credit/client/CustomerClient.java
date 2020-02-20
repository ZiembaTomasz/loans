package com.ziembatomasz.loans.credit.client;

import com.ziembatomasz.loans.credit.dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CustomerClient {
    private RestTemplate restTemplate;

    public void createCustomer(CustomerDto customerDto) {
        String fooResourceUrl = "http://customer:8081/customer";
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, customerDto, String.class);
    }
    public List<CustomerDto> getCustomers(List<Integer>creditIds){
        String creditIdsString= creditIds.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        String fooResourceUrl = "http://customer:8081/customer?creditIds=" + creditIdsString;
        ResponseEntity<CustomerDto[]> response = restTemplate.getForEntity(fooResourceUrl, CustomerDto[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
