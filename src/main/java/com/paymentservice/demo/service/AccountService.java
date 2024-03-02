package com.paymentservice.demo.service;

import com.paymentservice.demo.domain.Account;
import org.springframework.transaction.annotation.Transactional;

public interface AccountService {

    @Transactional(readOnly = true)
    Account getAccount(long accountId);

    @Transactional(readOnly = false)
    Account saveAccount(Account account);

}
