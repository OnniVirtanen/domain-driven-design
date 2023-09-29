package com.paymentservice.demo.domain.account.service;

import com.paymentservice.demo.domain.account.repository.AccountRepository;
import com.paymentservice.demo.domain.account.Account;
import com.paymentservice.demo.domain.account.exception.NoAccountByGivenIdException;
import com.paymentservice.demo.domain.account.valueobject.Money;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void transferMoney(UUID sourceAccountId, UUID targetAccountId, Money amount) {
        Account sourceAccount = accountRepository.findById(sourceAccountId)
                .orElseThrow(NoAccountByGivenIdException::new);
        Account targetAccount = accountRepository.findById(targetAccountId)
                .orElseThrow(NoAccountByGivenIdException::new);

        Money debitedAmount = sourceAccount.debit(amount);
        targetAccount.credit(debitedAmount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }
}
