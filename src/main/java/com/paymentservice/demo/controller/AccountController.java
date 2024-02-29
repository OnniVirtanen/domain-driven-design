package com.paymentservice.demo.controller;

import com.paymentservice.demo.domain.account.service.MoneyTransferService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/accounts")
public class AccountController {

    private final MoneyTransferService accountService;

    public AccountController(MoneyTransferService accountService) {
        this.accountService = accountService;
    }
}
