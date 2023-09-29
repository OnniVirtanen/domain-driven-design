package com.paymentservice.demo.domain.service;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.domain.AccountRepository;
import com.paymentservice.demo.domain.valueobject.AccountBalance;
import com.paymentservice.demo.domain.valueobject.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void transferMoney_shouldSucceed() {
        // Arrange
        UUID sourceAccountId = UUID.randomUUID();
        UUID targetAccountId = UUID.randomUUID();

        Account sourceAccount = new Account(sourceAccountId, new AccountBalance(BigDecimal.ONE));
        Account targetAccount = new Account(targetAccountId, new AccountBalance(BigDecimal.ZERO));
        when(accountRepository.findById(sourceAccountId)).thenReturn(Optional.of(sourceAccount));
        when(accountRepository.findById(targetAccountId)).thenReturn(Optional.of(targetAccount));
        Money amount = new Money(BigDecimal.ONE);

        // Act
        accountService.transferMoney(sourceAccount.getAccountId(), targetAccount.getAccountId(), amount);

        // Assert
        BigDecimal sourceAccountBalance = sourceAccount.getBalance().getBalance();
        BigDecimal targetAccountBalance = targetAccount.getBalance().getBalance();

        assertEquals(sourceAccountBalance, BigDecimal.ZERO);
        assertEquals(targetAccountBalance, BigDecimal.ONE);
        verify(accountRepository, times(2)).save(any(Account.class));
    }

    @Test
    void transferMoney_insufficientFunds_throws() {
        // Arrange
        UUID sourceAccountId = UUID.randomUUID();
        UUID targetAccountId = UUID.randomUUID();

        Account sourceAccount = new Account(sourceAccountId, new AccountBalance(BigDecimal.ZERO));
        Account targetAccount = new Account(targetAccountId, new AccountBalance(BigDecimal.ZERO));
        when(accountRepository.findById(sourceAccountId)).thenReturn(Optional.of(sourceAccount));
        when(accountRepository.findById(targetAccountId)).thenReturn(Optional.of(targetAccount));
        Money amount = new Money(BigDecimal.ONE);

        // Act & Assert
        Executable executable = () -> accountService.transferMoney(
                sourceAccount.getAccountId(),
                targetAccount.getAccountId(),
                amount
        );

        assertThrows(IllegalArgumentException.class, executable);
    }
}