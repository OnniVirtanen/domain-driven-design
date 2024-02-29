package com.paymentservice.demo.domain.account;

import java.util.UUID;

import com.paymentservice.demo.domain.account.valueobject.AccountBalance;

public class AccountDTO {
	
	private final UUID accountId;
    private AccountBalance balance;
    private boolean frozen;

	public AccountDTO(Account account) {
		this.accountId = account.getAccountId();
		this.balance = account.getBalance();
		this.frozen = account.isFrozen();
	}

	public AccountBalance getBalance() {
		return balance;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public UUID getAccountId() {
		return accountId;
	}
	
}
