package com.paymentservice.demo.domain;

import com.paymentservice.demo.domain.base.Entity;
import com.paymentservice.demo.domain.valueobject.Money;
import com.paymentservice.demo.domain.valueobject.ReadableDate;

import java.util.Objects;
import java.util.UUID;

public class MoneyTransaction extends Entity {

    private UUID moneyTransactionId;
    private Account sourceAccount;
    private Account destinationAccount;
    private Money amount;
    private ReadableDate date;
    private String description;

    public MoneyTransaction(Account fromAccount, Account toAccount, Money amount, String description) {
        this.sourceAccount = fromAccount;
        this.destinationAccount = toAccount;
        this.amount = amount;
        this.description = description;
        this.date = new ReadableDate();
    }

    public UUID getMoneyTransactionId() {
        return moneyTransactionId;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public Money getAmount() {
        return amount;
    }

    public ReadableDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyTransaction that = (MoneyTransaction) o;
        return Objects.equals(moneyTransactionId, that.moneyTransactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneyTransactionId);
    }

}
