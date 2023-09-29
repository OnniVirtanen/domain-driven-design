package com.paymentservice.demo.domain.account.service;

import com.paymentservice.demo.domain.account.valueobject.Money;
import java.util.UUID;

public interface AccountService {
    void transferMoney(UUID sourceAccountId, UUID targetAccountId, Money amount);
}
