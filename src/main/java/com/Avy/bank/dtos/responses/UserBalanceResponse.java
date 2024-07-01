package com.Avy.bank.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class UserBalanceResponse {
    private BigDecimal balance;
    private String message;
}
