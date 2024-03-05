package com.paymentservice.demo.infrastructure.repositoryimpl;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.domain.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

}
