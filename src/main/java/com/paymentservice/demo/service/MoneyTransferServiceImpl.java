package com.paymentservice.demo.service;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.domain.MoneyTransaction;
import com.paymentservice.demo.domain.valueobject.Money;
import com.paymentservice.demo.exception.AccountFrozenException;
import com.paymentservice.demo.exception.InsufficientFundsException;
import com.paymentservice.demo.exception.NoEntityFoundException;
import com.paymentservice.demo.exception.UnderSanctionsException;
import com.paymentservice.demo.repository.AccountRepository;
import com.paymentservice.demo.repository.MoneyTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {

    private final AccountRepository accountRepository;
    private final MoneyTransactionRepository transactionRepository;

    public MoneyTransferServiceImpl(AccountRepository accountRepository,
                                    MoneyTransactionRepository moneyTransactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = moneyTransactionRepository;
    }

    @Override
    public void transferMoney(long fromAccountId, long toAccountId, Money amount) {
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(NoEntityFoundException::new);
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(NoEntityFoundException::new);
        checkPrerequisites(fromAccount, toAccount, amount);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        MoneyTransaction transaction = new MoneyTransaction(fromAccount, toAccount, amount);
        transactionRepository.save(transaction);
    }

    private void checkPrerequisites(Account fromAccount, Account toAccount, Money amount) {
        if (fromAccount.isFrozen() || toAccount.isFrozen()) {
            throw new AccountFrozenException();
        }
        if (!hasSufficientFunds(fromAccount, amount)) {
            throw new InsufficientFundsException();
        }
        if (isUnderSanctions(fromAccount, toAccount)) {
            throw new UnderSanctionsException();
        }
    }

    private boolean isUnderSanctions(Account fromAccount, Account toAccount) {
        return fromAccount.getAccountHolder().isUnderSanctions() || toAccount.getAccountHolder().isUnderSanctions();
    }

    private boolean hasSufficientFunds(Account account, Money money) {
        return account.getBalance().compareTo(money) >= 0;
    }

}
