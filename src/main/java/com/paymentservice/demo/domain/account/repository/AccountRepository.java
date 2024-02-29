package com.paymentservice.demo.domain.account.repository;

import com.paymentservice.demo.domain.account.Account;
import com.paymentservice.demo.domain.account.AccountHistory;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface AccountRepository {
    Optional<Account> findById(UUID accountId);

    Account save(Account account);

    Set<Account> findAll();

	void update(Account account);

	AccountHistory getHistory(UUID accountId);
}
