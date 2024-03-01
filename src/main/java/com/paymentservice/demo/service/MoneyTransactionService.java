package com.paymentservice.demo.service;

import com.paymentservice.demo.valueobject.Money;
import org.springframework.transaction.annotation.Transactional;

public interface MoneyTransactionService {

    @Transactional(readOnly = false)
    void transferMoney(long srcAccountId, long toAccountId, Money amount);

}
