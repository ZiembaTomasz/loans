package com.ziembatomasz.loans.credit.repository;

import com.ziembatomasz.loans.credit.domain.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
}
