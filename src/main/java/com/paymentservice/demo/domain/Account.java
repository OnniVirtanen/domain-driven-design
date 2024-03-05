package com.paymentservice.demo.domain;

import com.paymentservice.demo.domain.base.Aggregate;
import com.paymentservice.demo.domain.valueobject.Money;

import java.util.Objects;

public class Account extends Aggregate {

    private long accountId;
    private Money balance;
    private boolean frozen;
    private Person accountHolder;

    public Account() {}

    public void withdraw(Money amount) {
        this.balance = balance.subtract(amount);
    }

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public Person getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(Person accountHolder) {
        this.accountHolder = accountHolder;
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
