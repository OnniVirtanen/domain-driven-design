package com.paymentservice.demo.domain.exception;

public class AccountFrozenException extends RuntimeException {
    public AccountFrozenException(String errorMessage) {
        super(errorMessage);
    }
}
