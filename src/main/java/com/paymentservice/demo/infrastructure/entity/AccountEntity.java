package com.paymentservice.demo.infrastructure.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class AccountEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;
    private BigDecimal balance;
    private boolean frozen;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_holder_id", referencedColumnName = "personId")
    private PersonEntity accountHolder;

    public AccountEntity() {}

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public PersonEntity getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(PersonEntity accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity accountEntity = (AccountEntity) o;
        return accountId == accountEntity.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

}
