package com.paymentservice.demo.service;

import com.paymentservice.demo.domain.valueobject.Money;
import org.springframework.transaction.annotation.Transactional;

public interface MoneyTransferService {

    @Transactional(readOnly = false)
    void transferMoney(long fromAccountId, long toAccountId, Money amount);

}
