package com.Avy.bank.services;


import com.Avy.bank.dtos.requests.UserBalanceRequest;
import com.Avy.bank.dtos.requests.UserDepositRequest;
import com.Avy.bank.dtos.requests.UserFundTransferRequest;
import com.Avy.bank.dtos.requests.UserWithdrawRequest;
import com.Avy.bank.dtos.responses.UserBalanceResponse;
import com.Avy.bank.dtos.responses.UserDepositResponse;
import com.Avy.bank.dtos.responses.UserFundTransferResponse;
import com.Avy.bank.dtos.responses.UserWithdrawResponse;
import com.Avy.bank.exceptions.AccountNumberNotFound;
import com.Avy.bank.exceptions.InvalidAmountException;

public interface AccountService {


    UserDepositResponse makeDeposit(UserDepositRequest request) throws AccountNumberNotFound, InvalidAmountException;

    UserBalanceResponse checkBalance(UserBalanceRequest request) throws AccountNumberNotFound;

    UserWithdrawResponse makeWithdrawal(UserWithdrawRequest request) throws InvalidAmountException, AccountNumberNotFound;

    UserFundTransferResponse transferFund(UserFundTransferRequest request) throws AccountNumberNotFound, InvalidAmountException;
}
