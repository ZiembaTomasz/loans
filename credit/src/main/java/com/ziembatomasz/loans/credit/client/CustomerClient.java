package com.ziembatomasz.loans.credit.client;


import com.ziembatomasz.loans.credit.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerClient {
    RestTemplate restTemplate = new RestTemplate();


    public void createCustomer(CustomerDto customerDto) {
        String fooResourceUrl = "http://customer:8081/customer";
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, customerDto, String.class);
    }
    public List<CustomerDto> getCustomers(List<Integer>creditIds){
        String creditIdsString= creditIds.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        String fooResourceUrl = "http://customer:8081/customer?creditsId=" + creditIdsString;
        ResponseEntity<CustomerDto[]> response = restTemplate.getForEntity(fooResourceUrl, CustomerDto[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
