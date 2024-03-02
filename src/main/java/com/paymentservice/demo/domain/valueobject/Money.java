package com.paymentservice.demo.domain.valueobject;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Embeddable
public class Money {

    private BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.HALF_EVEN);
    }

    protected Money() {}

    public Money(String value) {
        this(new BigDecimal(value));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.setScale(2, RoundingMode.HALF_EVEN).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
