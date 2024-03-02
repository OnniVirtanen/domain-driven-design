package com.paymentservice.demo.domain.valueobject;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class SocialSecurityNumber {

    private String value;

    public SocialSecurityNumber(String value) {
        this.value = value;
    }

    protected SocialSecurityNumber() {}

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
