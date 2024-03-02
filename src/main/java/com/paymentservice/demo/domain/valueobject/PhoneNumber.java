package com.paymentservice.demo.domain.valueobject;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class PhoneNumber {

    private String value;

    public PhoneNumber(String value) {
        this.value = value;
    }

    protected PhoneNumber() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
