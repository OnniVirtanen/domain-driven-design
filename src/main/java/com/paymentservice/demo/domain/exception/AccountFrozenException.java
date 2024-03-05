package com.paymentservice.demo.domain.exception;

public class AccountFrozenException extends RuntimeException {

    public AccountFrozenException(String message) {
        super(message);
    }

    public AccountFrozenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountFrozenException(Throwable cause) {
        super(cause);
    }

    public AccountFrozenException() {

    }

}
