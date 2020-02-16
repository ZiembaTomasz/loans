package com.ziembatomasz.loans.credit.mapper;

import com.ziembatomasz.loans.credit.domain.Credit;
import com.ziembatomasz.loans.credit.dto.CreditDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditMapper {
    public List<CreditDto>mapToCreditDtoList(List<Credit>creditList){
        return creditList.stream()
                .map(this::mapToCreditDto)
                .collect(Collectors.toList());
    }
    public CreditDto mapToCreditDto(Credit credit){
        return new CreditDto(credit.getId(), credit.getCreditName());
    }
    public Credit mapToCredit(CreditDto creditDto){
        return new Credit(creditDto.getId(), creditDto.getCreditName());
    }
}
