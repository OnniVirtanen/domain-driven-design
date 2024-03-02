package com.paymentservice.demo.webservice;

import com.paymentservice.demo.service.MoneyTransferService;
import com.paymentservice.demo.webservice.command.TransferMoneyCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transfer")
public class MoneyTransferWebServiceImpl implements MoneyTransferWebService {

    private final MoneyTransferService moneyTransferService;

    public MoneyTransferWebServiceImpl(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping()
    @Override
    public void transferMoney(@RequestBody TransferMoneyCommand command) {
        moneyTransferService.transferMoney(command.fromAccountId(),
                command.toAccountId(), command.amount(), command.description());
    }

}
