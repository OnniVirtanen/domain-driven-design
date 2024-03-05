package com.paymentservice.demo.domain;

import com.paymentservice.demo.domain.base.Entity;
import com.paymentservice.demo.domain.valueobject.Money;
import com.paymentservice.demo.domain.valueobject.ReadableDate;

import java.util.UUID;

public class MoneyTransaction extends Entity {

    private UUID moneyTransactionId;
    private Account sourceAccount;
    private Account destinationAccount;
    private Money amount;
    private ReadableDate date;
    private String description;

    public MoneyTransaction(Account fromAccount, Account toAccount, Money amount, String description) {

    }

}
