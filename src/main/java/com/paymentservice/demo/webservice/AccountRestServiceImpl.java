package com.paymentservice.demo.webservice;

import com.paymentservice.demo.api.AccountDTO;
import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.service.AccountService;
import com.paymentservice.demo.testdata.TestDataGenerator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "account")
public class AccountRestServiceImpl implements AccountRestService {

    private final AccountService accountService;

    public AccountRestServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/{accountId}")
    @Override
    public AccountDTO getAccount(@PathVariable long accountId) {
        return new AccountDTO(accountService.getAccount(accountId));
    }

    @GetMapping
    @Override
    public Page<AccountDTO> getAccounts(Pageable pageable) {
        return accountService.getAccounts(pageable).map(AccountDTO::new);
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
