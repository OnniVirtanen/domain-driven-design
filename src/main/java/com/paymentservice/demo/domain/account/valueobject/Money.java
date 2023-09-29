package com.paymentservice.demo.domain.account.valueobject;

import com.paymentservice.demo.shared.markerinterface.ValueObject;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money implements ValueObject {
    private final BigDecimal amount;

    public Money(@NonNull BigDecimal amount) {
        this.amount = validate(amount);
    }

    public @NonNull BigDecimal getAmount() {
        return amount;
    }

    public @NonNull Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public @NonNull Money subtract(Money other) {
        BigDecimal result = this.amount.subtract(other.amount);
        if (isNegativeAmount(result)) {
            throw new IllegalArgumentException("Resulting amount cannot be negative");
        }
        return new Money(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private static @NonNull BigDecimal validate(@NonNull BigDecimal amount) {
        if (!isValid(amount)) {
            throw new IllegalArgumentException("Invalid amount: " + amount);
        }
        return amount;
    }

    public static boolean isValid(@NonNull BigDecimal amount) {
        return !(isNegativeAmount(amount));
    }

    private static boolean isNegativeAmount(@NonNull BigDecimal amount) {
        return (amount.compareTo(BigDecimal.ZERO) < 0);
    }
}
