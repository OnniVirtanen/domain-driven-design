package com.paymentservice.demo.api;

import com.paymentservice.demo.domain.Account;

public class AccountDTO {

    private final long accountId;
    private final String balance;
    private final boolean frozen;
    private final long accountHolderId;

    public AccountDTO(Account account) {
        this.accountId = account.getAccountId();
        this.balance = account.getBalance().toString();
        this.frozen = account.isFrozen();
        this.accountHolderId = account.getAccountHolder().getPersonId();
    }

    public long getAccountId() {
        return accountId;
    }

    public String getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public long getAccountHolder() {
        return accountHolderId;
    }

}
