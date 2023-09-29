package com.paymentservice.demo.domain.valueobject;


import java.math.BigDecimal;
import java.util.Objects;

public final class AccountBalance {

    private final BigDecimal balance;

    public AccountBalance(BigDecimal balance) {
        validateBalance(balance);

        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private static void validateBalance(BigDecimal balance) {
        if (balance == null) {
            throw new NullPointerException("Balance cannot be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBalance that = (AccountBalance) o;
        return Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "balance=" + balance +
                '}';
    }

    public AccountBalance addBalance(Money amount) {
        return new AccountBalance(this.balance.add(amount.getAmount()));
    }

    public AccountBalance subtractBalance(Money amount) {
        return new AccountBalance(this.balance.subtract(amount.getAmount()));
    }
}
