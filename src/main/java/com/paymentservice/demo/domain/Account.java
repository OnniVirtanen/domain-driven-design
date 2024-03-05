package com.paymentservice.demo.domain;

import com.paymentservice.demo.domain.base.Aggregate;
import com.paymentservice.demo.domain.valueobject.Money;

import java.util.Objects;

public class Account extends Aggregate {

    private long accountId;
    private Money balance;
    private boolean frozen;
    private Person accountHolder;

    public Account(long accountId, Money balance, boolean frozen, Person accountHolder) {
        this.accountId = accountId;
        this.balance = balance;
        this.frozen = frozen;
        this.accountHolder = accountHolder;
    }

    public void withdraw(Money amount) {
        this.balance = balance.subtract(amount);
    }

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public long getAccountId() {
        return accountId;
    }

    public Money getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public Person getAccountHolder() {
        return accountHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

}
