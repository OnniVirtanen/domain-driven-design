package com.paymentservice.demo.domain.account;

import com.paymentservice.demo.domain.account.valueobject.AccountBalance;
import com.paymentservice.demo.domain.account.valueobject.Money;
import com.paymentservice.demo.shared.markerinterface.DomainObject;

import java.util.Objects;
import java.util.UUID;

public class Account implements DomainObject {

    private final UUID accountId;
    private AccountBalance balance;

    public Account(UUID accountId, AccountBalance balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Money debit(Money amount) {
        if (transferAmountExceedsBalance(amount)) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        this.balance = this.balance.subtractBalance(amount);
        return amount;
    }

    public void credit(Money amount) {
        this.balance = this.balance.addBalance(amount);
    }

    public UUID getAccountId() {
        return accountId;
    }

    public AccountBalance getBalance() {
        return balance;
    }

    private boolean transferAmountExceedsBalance(Money transferAmount) {
        return (transferAmount.getAmount().compareTo(balance.getBalance()) > 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }
}
