package com.paymentservice.demo.domain;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface AccountRepository {
    Optional<Account> findById(UUID accountId);

    void save(Account account);

    Set<Account> findAll();
}
