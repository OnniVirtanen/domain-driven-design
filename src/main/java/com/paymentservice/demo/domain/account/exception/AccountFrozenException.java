package com.paymentservice.demo.domain.account.exception;

public class AccountFrozenException extends RuntimeException {
    public AccountFrozenException(String errorMessage) {
        super(errorMessage);
    }
}
