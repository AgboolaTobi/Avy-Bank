package com.Avy.bank.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class UserDepositRequest {

    private String accountName;
    private String accountNumber;
    private BigDecimal amount;
    private String description;
    private String depositor;
    private String depositDate;

}
