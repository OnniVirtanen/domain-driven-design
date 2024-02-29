package com.paymentservice.demo.domain.account.service;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.paymentservice.demo.domain.account.AccountDTO;
import com.paymentservice.demo.domain.account.AccountHistory;
import com.paymentservice.demo.domain.account.valueobject.AccountBalance;

public interface AccountService {

	@Transactional(readOnly = true)
	AccountDTO getAccount(UUID accountId);
	
	@Transactional(readOnly = true)
	AccountBalance getBalance(UUID accountId);
	
	@Transactional(readOnly = true)
	AccountHistory getHistory(UUID accountId);
	
	@Transactional(readOnly = false)
	AccountDTO createAccount(AccountDTO account);
	
	@Transactional(readOnly = false)
	void freezeAccount(UUID accountId);
	
}
