package com.paymentservice.demo.domain.valueobject;

import com.paymentservice.demo.domain.base.ValueObject;

import java.util.Objects;

public final class PhoneNumber extends ValueObject {

    private final String value;

    public PhoneNumber(String value) {
        this.value = value;
    }

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
