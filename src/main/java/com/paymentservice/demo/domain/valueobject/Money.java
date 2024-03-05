package com.paymentservice.demo.domain.valueobject;

import com.paymentservice.demo.domain.base.ValueObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Money extends ValueObject {

    private final BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.HALF_UP);
    }

    public Money(String value) {
        this(new BigDecimal(value));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.setScale(2, RoundingMode.HALF_UP).toString();
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

    public Money subtract(Money amount) {
        return new Money(this.value.subtract(amount.value));
    }

    public Money add(Money amount) {
        return new Money(this.value.add(amount.value));
    }

    public int compareTo(Money money) {
        return this.value.compareTo(money.value);
    }

}
