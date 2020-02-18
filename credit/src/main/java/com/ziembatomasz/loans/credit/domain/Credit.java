package com.ziembatomasz.loans.credit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String creditName;
}
