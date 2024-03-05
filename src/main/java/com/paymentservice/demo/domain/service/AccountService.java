package com.paymentservice.demo.domain.service;

import com.paymentservice.demo.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface AccountService {

    @Transactional(readOnly = true)
    Account getAccount(long accountId);

    @Transactional(readOnly = false)
    Account saveAccount(Account account);

    Page<Account> getAccounts(Pageable pageable);
}
