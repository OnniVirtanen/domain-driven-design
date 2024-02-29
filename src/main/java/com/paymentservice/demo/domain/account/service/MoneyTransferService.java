package com.paymentservice.demo.domain.account.service;

import com.paymentservice.demo.domain.account.valueobject.Money;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

public interface MoneyTransferService {
	
	@Transactional(readOnly = false)
    void transferMoney(UUID sourceAccountId, UUID targetAccountId, Money amount);
	
}
