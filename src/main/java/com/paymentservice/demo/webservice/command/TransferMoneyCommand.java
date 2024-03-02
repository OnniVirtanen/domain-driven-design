package com.paymentservice.demo.webservice.command;

import com.paymentservice.demo.domain.valueobject.Money;

public record TransferMoneyCommand(
    long fromAccountId,
    long toAccountId,
    Money amount,
    String description
) {
}
