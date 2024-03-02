package com.paymentservice.demo.exception;

public class NoEntityFoundException extends RuntimeException {

    public NoEntityFoundException(String message) {
        super(message);
    }

    public NoEntityFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEntityFoundException(Throwable cause) {
        super(cause);
    }

    public NoEntityFoundException() {

    }

}
