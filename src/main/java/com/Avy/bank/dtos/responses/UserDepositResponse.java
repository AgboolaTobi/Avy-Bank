package com.Avy.bank.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class UserDepositResponse {
    private UUID transactionId;
    private String message;
}
