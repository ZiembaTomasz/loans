package com.ziembatomasz.loans.credit.service;

import com.ziembatomasz.loans.credit.client.CustomerClient;
import com.ziembatomasz.loans.credit.client.ProductClient;
import com.ziembatomasz.loans.credit.dto.CreditDto;
import com.ziembatomasz.loans.credit.dto.CustomerDto;
import com.ziembatomasz.loans.credit.dto.LoanDto;
import com.ziembatomasz.loans.credit.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {
    @InjectMocks
    LoanService loanService;
    @Mock
    ProductClient productClient;
    @Mock
    CustomerClient customerClient;
    @Mock
    CreditService creditService;

    @Test
    public void shouldCreateLoanTest() {
        //Given
        CustomerDto customerDto = new CustomerDto("66150212345", "Andrzej", "Kowalski", 7);
        CreditDto creditDto = new CreditDto(null, "Fast Loan");
        CreditDto savedCredit = new CreditDto(7, "Fast Loan");
        ProductDto productDto = new ProductDto("Good Credit", 20000, 7);
        LoanDto loanDto = new LoanDto(creditDto, customerDto, productDto);
        when(creditService.createCredit(creditDto)).thenReturn(savedCredit);
        //When
        loanService.createLoan(loanDto);
        //Then
        verify(creditService, times(1)).createCredit(creditDto);
        verify(customerClient, times(1)).createCustomer(customerDto);
        verify(productClient, times(1)).createProduct(productDto);
    }

    @Test
    public void shouldGetLoanTest() {
        //Given
        CustomerDto customerDto = new CustomerDto("66150212345", "Andrzej", "Kowalski", 7);
        CreditDto creditDto = new CreditDto(7, "Fast Loan");
        ProductDto productDto = new ProductDto("Good Credit", 20000, 7);

        List<Integer> creditIds = Collections.singletonList(creditDto.getId());

        List<CreditDto> creditDtos = Collections.singletonList(creditDto);
        List<ProductDto> productDtos = Collections.singletonList(productDto);
        List<CustomerDto> customerDtos = Collections.singletonList(customerDto);

        when(creditService.getCredits()).thenReturn(creditDtos);
        when(customerClient.getCustomers(creditIds)).thenReturn(customerDtos);
        when(productClient.getProducts(creditIds)).thenReturn(productDtos);
        //When
        List<LoanDto> myLoans = loanService.getLoan();

        //Then
        assertThat(myLoans).hasSize(1);
        LoanDto resultingLoan = myLoans.get(0);
        assertThat(resultingLoan.getCredit()).isEqualTo(creditDto);
        assertThat(resultingLoan.getCustomer()).isEqualTo(customerDto);
        assertThat(resultingLoan.getProduct()).isEqualTo(productDto);
    }
}