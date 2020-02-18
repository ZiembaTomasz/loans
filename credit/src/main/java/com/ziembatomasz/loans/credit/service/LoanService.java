package com.ziembatomasz.loans.credit.service;

import com.ziembatomasz.loans.credit.client.CustomerClient;
import com.ziembatomasz.loans.credit.client.ProductClient;
import com.ziembatomasz.loans.credit.dto.CreditDto;
import com.ziembatomasz.loans.credit.dto.CustomerDto;
import com.ziembatomasz.loans.credit.dto.LoanDto;
import com.ziembatomasz.loans.credit.dto.ProductDto;

import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.util.Contracts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LoanService {
    private CreditService creditService;
    private CustomerClient customerClient;
    private ProductClient productClient;


    public void createLoan(LoanDto loanDto) {
        Contracts.assertTrue(loanDto.getCredit().getId() == null, "Credit with this id already exists");
        CreditDto savedCredit = creditService.createCredit(loanDto.getCredit());
        loanDto.getCustomer().setCreditId(savedCredit.getId());
        loanDto.getProduct().setCreditId(savedCredit.getId());
        customerClient.createCustomer(loanDto.getCustomer());
        productClient.createProduct(loanDto.getProduct());
    }

    public List<LoanDto> getLoan() {
        List<LoanDto> loanDtos = new ArrayList<>();
        List<CreditDto> creditDtos = creditService.getCredits();
        List<Integer>creditIds = creditDtos.stream()
                .map(CreditDto::getId)
                .collect(Collectors.toList());
        List<CustomerDto> customerDtos = customerClient.getCustomers(creditIds);
        List<ProductDto> productDtos = productClient.getProducts(creditIds);

        for (CreditDto creditDto : creditDtos) {
            LoanDto loanDto = new LoanDto();
            loanDto.setCredit(creditDto);
            loanDtos.add(loanDto);

            CustomerDto creditCustomer = findCustomerWithCreditId(customerDtos, creditDto.getId());
            loanDto.setCustomer(creditCustomer);

            ProductDto creditProduct = findProductWithCreditId(productDtos, creditDto.getId());
            loanDto.setProduct(creditProduct);
        }
        return loanDtos;
    }

    private ProductDto findProductWithCreditId(List<ProductDto> productDtos, int creditId) {
        return productDtos.stream()
                .filter(productDto -> creditId == productDto.getCreditId())
                .findAny()
                .orElse(null);
    }

    private CustomerDto findCustomerWithCreditId(List<CustomerDto> customerDtos, int creditId) {
        return customerDtos.stream()
                .filter(customerDto -> creditId == customerDto.getCreditId())
                .findAny()
                .orElse(null);
    }
}
