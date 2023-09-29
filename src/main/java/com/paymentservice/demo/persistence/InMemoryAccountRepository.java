package com.paymentservice.demo.persistence;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.domain.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public class InMemoryAccountRepository implements AccountRepository {

    private final Map<UUID, Account> accounts = new HashMap<>();

    @Override
    public Optional<Account> findById(UUID accountId) {
        if (accounts.containsKey(accountId)) {
            return Optional.of(accounts.get(accountId));
        }
        return Optional.empty();
    }

    @Override
    public void save(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    @Override
    public Set<Account> findAllAccounts() {
        return new HashSet<>(accounts.values());
    }
}
