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
import java.util.UUID;

@Entity
public class MoneyTransactionEntity extends BaseEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID moneyTransactionId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "source_account_id", referencedColumnName = "accountId")
    private AccountEntity sourceAccountEntity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "destination_account_id", referencedColumnName = "accountId")
    private AccountEntity destinationAccountEntity;
    private BigDecimal amount;
    private String date;
    private String description;

    public MoneyTransactionEntity() {

    }

    public UUID getMoneyTransactionId() {
        return moneyTransactionId;
    }

    public void setMoneyTransactionId(UUID moneyTransactionId) {
        this.moneyTransactionId = moneyTransactionId;
    }

    public AccountEntity getSourceAccountEntity() {
        return sourceAccountEntity;
    }

    public void setSourceAccountEntity(AccountEntity sourceAccountEntity) {
        this.sourceAccountEntity = sourceAccountEntity;
    }

    public AccountEntity getDestinationAccountEntity() {
        return destinationAccountEntity;
    }

    public void setDestinationAccountEntity(AccountEntity destinationAccountEntity) {
        this.destinationAccountEntity = destinationAccountEntity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyTransactionEntity that = (MoneyTransactionEntity) o;
        return Objects.equals(moneyTransactionId, that.moneyTransactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneyTransactionId);
    }

}
