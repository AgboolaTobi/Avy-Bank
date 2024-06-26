package com.Avy.bank.accountTests;

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
import com.Avy.bank.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserAccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testThatADepositTransactionCanBeExecutedOnAnExistingAccount() throws AccountNumberNotFound, InvalidAmountException {
        UserDepositRequest request = new UserDepositRequest();

        request.setAccountName("Agboola Tobi Samuel");
        request.setAccountNumber("0000000028");
        request.setAmount(BigDecimal.valueOf(5000));
        request.setDescription("School fees");
        request.setDepositor("Falade Adebola");
        request.setDepositDate("25/06/2024");

        UserDepositResponse response = accountService.makeDeposit(request);

        assertThat(response).isNotNull();
    }

    @Test
    public void testThatADepositTransactionCanBeExecutedOnAnExistingAccount2() throws AccountNumberNotFound, InvalidAmountException {
        UserDepositRequest request = new UserDepositRequest();
        request.setAccountName("Agu Sandra");
        request.setAccountNumber("0000000019");
        request.setAmount(BigDecimal.valueOf(75000));
        request.setDescription("Feeding Allowance");
        request.setDepositor("Agboola Boluwatife");
        request.setDepositDate("27/06/2024");

        UserDepositResponse response = accountService.makeDeposit(request);

        assertThat(response).isNotNull();

    }

        @Test
    public void testThatMultipleDepositsCanBeMadeOnExistingAccount() throws AccountNumberNotFound, InvalidAmountException {
        UserDepositRequest request = new UserDepositRequest();

        request.setAccountName("Agu Sandra");
        request.setAccountNumber("0000000019");
        request.setAmount(BigDecimal.valueOf(2500));
        request.setDescription("Feeding Allowance");
        request.setDepositor("Agboola Boluwatife");
        request.setDepositDate("27/06/2024");

        UserDepositResponse response = accountService.makeDeposit(request);

        assertThat(response).isNotNull();
    }

    @Test
    public void testThatAttemptToDepositANegativeAmountThrowsException(){
        UserDepositRequest request = new UserDepositRequest();

        request.setAccountName("Agboola Tobi Samuel");
        request.setAccountNumber("0000000028");
        request.setAmount(BigDecimal.valueOf(-500));
        request.setDescription("School fees");
        request.setDepositor("Falade Adebola");
        request.setDepositDate("25/06/2024");
        assertThrows(InvalidAmountException.class,()->accountService.makeDeposit(request));
    }

    @Test
    public void  testThatAnExistingAccountBalanceCanBeFound() throws AccountNumberNotFound {
        UserBalanceRequest request = new UserBalanceRequest();
        request.setAccountNumber("0000000028");

        UserBalanceResponse response = accountService.checkBalance(request);
        System.out.println(response.getBalance());
        assertThat(response).isNotNull();

    }

    @Test
    public void testThatWithdrawalCanBMadeOnAnExistingAccount() throws InvalidAmountException, AccountNumberNotFound {
        UserWithdrawRequest request = new UserWithdrawRequest();
        request.setAccountNumber("0000000019");
        request.setAmount(BigDecimal.valueOf(1500));
        request.setPerformedAt("25/06/2024");
        request.setAccountName("Agu Sandra");
        request.setPerformedBy("Agu Sandra");


        UserWithdrawResponse response = accountService.makeWithdrawal(request);

        assertThat(response).isNotNull();

    }
    @Test
    public void testThatMultipleWithdrawalCanBePerformedOnAnExistingAccount() throws InvalidAmountException, AccountNumberNotFound {
        UserWithdrawRequest request = new UserWithdrawRequest();
        request.setAccountNumber("0000000019");
        request.setAmount(BigDecimal.valueOf(1550));
        request.setPerformedBy("Agu Sandra");
        request.setDescription("Personal");
        request.setAccountName("Agu Sandra");
        request.setPerformedAt("25/06/2024");

        UserWithdrawResponse response = accountService.makeWithdrawal(request);

        assertThat(response).isNotNull();
    }

    @Test
    public void testThatFundTransferCanBeMadeBetweenTwoExistingAccounts() throws AccountNumberNotFound, InvalidAmountException {
        UserFundTransferRequest request = new UserFundTransferRequest();
        request.setFromAccount("0000000019");
        request.setToAccount("0000000028");
        request.setAmount(BigDecimal.valueOf(1200));
        request.setDescription("Sent for upkeep");
        request.setPerformedBy("Agu Sandra");

        UserFundTransferResponse response = accountService.transferFund(request);
        System.out.println(response);
        assertThat(response).isNotNull();

    }
}
