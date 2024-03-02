package com.paymentservice.demo.api;

import com.paymentservice.demo.domain.Account;

import java.math.BigDecimal;

public class AccountDTO {

    private final long accountId;
    private final BigDecimal balance;
    private final boolean frozen;
    private final long accountHolderId;

    public AccountDTO(Account account) {
        this.accountId = account.getAccountId();
        this.balance = account.getBalance();
        this.frozen = account.isFrozen();
        this.accountHolderId = account.getAccountHolder().getPersonId();
    }

    public long getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public long getAccountHolder() {
        return accountHolderId;
    }

}
