package com.paymentservice.demo.exception;

public class UnderSanctionsException extends RuntimeException {

    public UnderSanctionsException(String message) {
        super(message);
    }

    public UnderSanctionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnderSanctionsException(Throwable cause) {
        super(cause);
    }

    public UnderSanctionsException() {

    }

}
