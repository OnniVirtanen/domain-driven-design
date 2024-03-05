package com.paymentservice.demo.application.rest;

import com.paymentservice.demo.application.command.TransferMoneyCommand;
import org.springframework.transaction.annotation.Transactional;

public interface MoneyTransferRestController {

    @Transactional(readOnly = false)
    void transferMoney(TransferMoneyCommand command);

}
