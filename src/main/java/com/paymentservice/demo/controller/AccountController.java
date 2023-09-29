package com.paymentservice.demo.controller;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.domain.service.AccountService;
import com.paymentservice.demo.domain.valueobject.AccountBalance;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/addTestData")
    void addTestData() {
        Account account1 = new Account(UUID.randomUUID(), new AccountBalance(BigDecimal.valueOf(15.5)));
        Account account2 = new Account(UUID.randomUUID(), new AccountBalance(BigDecimal.valueOf(30.5)));

        accountService.addAccount(account1);
        accountService.addAccount(account2);
    }

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Set<Account>> findAllAccounts() {
        Set<Account> accounts = accountService.findAllAccounts();
        return ResponseEntity.ok(accounts);
    }
}
