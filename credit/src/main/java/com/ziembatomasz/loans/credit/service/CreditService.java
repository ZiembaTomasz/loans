package com.ziembatomasz.loans.credit.service;

import com.ziembatomasz.loans.credit.domain.Credit;
import com.ziembatomasz.loans.credit.dto.CreditDto;
import com.ziembatomasz.loans.credit.mapper.CreditMapper;
import com.ziembatomasz.loans.credit.repository.CreditRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CreditService {
    private CreditMapper creditMapper;
    private CreditRepository creditRepository;
    public void createCredit(CreditDto creditDto){
        Credit credit = creditMapper.mapToCredit(creditDto);
        creditRepository.save(credit);
    }
    public List<CreditDto>getCredits(){
        return creditMapper.mapToCreditDtoList(creditRepository.findAll());
    }
}
