package com.paymentservice.demo.service;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccount(long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

}
