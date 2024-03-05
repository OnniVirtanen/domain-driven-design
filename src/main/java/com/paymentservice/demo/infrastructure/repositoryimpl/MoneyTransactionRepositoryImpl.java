package com.paymentservice.demo.infrastructure.repositoryimpl;

import com.paymentservice.demo.domain.MoneyTransaction;
import com.paymentservice.demo.domain.repository.MoneyTransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class MoneyTransactionRepositoryImpl implements MoneyTransactionRepository {

    @Override
    public MoneyTransaction save(MoneyTransaction object) {
        return null;
    }

    @Override
    public Optional<MoneyTransaction> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public MoneyTransaction update(MoneyTransaction object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

}
