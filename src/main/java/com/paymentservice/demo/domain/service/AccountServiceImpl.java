package com.paymentservice.demo.domain.service;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.domain.AccountRepository;
import com.paymentservice.demo.domain.exception.NoAccountByGivenIdException;
import com.paymentservice.demo.domain.valueobject.Money;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
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

    @Override
    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Set<Account> findAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
