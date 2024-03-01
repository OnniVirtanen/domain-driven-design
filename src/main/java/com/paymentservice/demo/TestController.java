package com.paymentservice.demo;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.repository.AccountRepository;
import com.paymentservice.demo.valueobject.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TestController {

    private final AccountRepository repository;

    public TestController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    ResponseEntity<List<Account>> createTestAccounts() {

        for (int i = 0; i < 10; i++) {
            Account account = new Account(
                    null,
                    new Money("512512"),
                    false);
            repository.save(account);
        }

        return ResponseEntity.of(Optional.of(repository.findAll()));
    }
}
