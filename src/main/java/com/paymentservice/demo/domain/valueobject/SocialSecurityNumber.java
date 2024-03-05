package com.paymentservice.demo.domain.valueobject;

import com.paymentservice.demo.domain.base.ValueObject;

import java.util.Objects;

public final class SocialSecurityNumber extends ValueObject {

    private final String value;

    public SocialSecurityNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialSecurityNumber that = (SocialSecurityNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
