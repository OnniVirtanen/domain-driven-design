package com.paymentservice.demo.domain.service;

import com.paymentservice.demo.domain.valueobject.Money;
import java.util.UUID;

public interface AccountService {
    void transferMoney(UUID sourceAccountId, UUID targetAccountId, Money amount);
}
