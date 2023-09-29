package com.paymentservice.demo.domain.account.repository;

import com.paymentservice.demo.domain.account.Account;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface AccountRepository {
    Optional<Account> findById(UUID accountId);

    void save(Account account);

    Set<Account> findAll();
}
