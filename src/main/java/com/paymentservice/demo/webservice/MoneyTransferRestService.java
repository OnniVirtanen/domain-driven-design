package com.paymentservice.demo.webservice;

import com.paymentservice.demo.webservice.command.TransferMoneyCommand;
import org.springframework.transaction.annotation.Transactional;

public interface MoneyTransferRestService {

    @Transactional(readOnly = false)
    void transferMoney(TransferMoneyCommand command);

}
