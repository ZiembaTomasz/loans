package com.ziembatomasz.loans.credit.service;

import com.ziembatomasz.loans.credit.domain.Credit;
import com.ziembatomasz.loans.credit.dto.CreditDto;
import com.ziembatomasz.loans.credit.mapper.CreditMapper;
import com.ziembatomasz.loans.credit.repository.CreditRepository;
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
public class CreditServiceTest {
    @Mock
    CreditRepository creditRepository;
    CreditMapper creditMapper = new CreditMapper();
    CreditService creditService;

    @Before
    public void createCreditObjectService() {
        creditService = new CreditService(creditMapper, creditRepository);
    }

    @Test
    public void shouldGetCreditsTest() {
        //Given
        List<Credit> credits = new ArrayList<>();
        Credit credit = new Credit(7, "Fast Loan");
        credits.add(credit);
        when(creditRepository.findAll()).thenReturn(credits);
        //When
        List<CreditDto> myCredits = creditService.getCredits();
        //Then
        assertEquals(1, myCredits.size());
    }

    @Test
    public void shouldCreateCreditTest() {
        //Given
        CreditDto creditDto = new CreditDto(7, "Fast Loan");
        Credit credit = creditMapper.mapToCredit(creditDto);
        when(creditRepository.save(credit)).thenReturn(credit);
        //When
        CreditDto resultCredit = creditService.createCredit(creditDto);
        //Then
        assertEquals(resultCredit, creditDto);
    }
}