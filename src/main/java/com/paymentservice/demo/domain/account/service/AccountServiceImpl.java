package com.paymentservice.demo.domain.account.service;

import java.util.UUID;

import com.paymentservice.demo.domain.account.Account;
import com.paymentservice.demo.domain.account.AccountDTO;
import com.paymentservice.demo.domain.account.AccountHistory;
import com.paymentservice.demo.domain.account.exception.NoAccountByGivenIdException;
import com.paymentservice.demo.domain.account.repository.AccountRepository;
import com.paymentservice.demo.domain.account.valueobject.AccountBalance;

public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDTO getAccount(UUID accountId) {
		Account account = accountRepository.findById(accountId).orElseThrow(NoAccountByGivenIdException::new);
		return new AccountDTO(account);
	}

	@Override
	public AccountBalance getBalance(UUID accountId) {
		Account account = accountRepository.findById(accountId).orElseThrow(NoAccountByGivenIdException::new);
		return account.getBalance();
	}

	@Override
	public AccountHistory getHistory(UUID accountId) {
		return accountRepository.getHistory(accountId);
	}

	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		Account account = accountRepository.save(new Account(accountDTO));
		return new AccountDTO(account);
	}

	@Override
	public void freezeAccount(UUID accountId) {
		Account account = accountRepository.findById(accountId).orElseThrow(NoAccountByGivenIdException::new);
		account.freeze();
		accountRepository.update(account);
	}
	
}
