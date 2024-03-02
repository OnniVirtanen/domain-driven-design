package com.paymentservice.demo.webservice;

import com.paymentservice.demo.api.AccountDTO;
import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.domain.Person;
import com.paymentservice.demo.service.AccountService;
import com.paymentservice.demo.testdata.TestDataGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RestController
@RequestMapping(path = "account")
public class AccountWebServiceImpl implements AccountWebService {

    private final AccountService accountService;

    public AccountWebServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/{accountId}")
    @Override
    public AccountDTO getAccount(@PathVariable long accountId) {
        return new AccountDTO(accountService.getAccount(accountId));
    }

    @PostMapping(path = "/testdata/amount/{amount}")
    @Override
    public void createTestData(@PathVariable long amount) {
        for (int i = 0; i < amount; i++) {
            Account account = TestDataGenerator.createRandomAccount();
            accountService.saveAccount(account);
        }
    }

}
