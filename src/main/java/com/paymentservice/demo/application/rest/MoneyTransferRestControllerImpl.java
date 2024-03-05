package com.paymentservice.demo.application.rest;

import com.paymentservice.demo.domain.service.MoneyTransferService;
import com.paymentservice.demo.application.command.TransferMoneyCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transfer")
public class MoneyTransferRestControllerImpl implements MoneyTransferRestController {

    private final MoneyTransferService moneyTransferService;

    public MoneyTransferRestControllerImpl(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping
    @Override
    public void transferMoney(@RequestBody TransferMoneyCommand command) {
        moneyTransferService.transferMoney(command.fromAccountId(),
                command.toAccountId(), command.amount(), command.description());
    }

}
