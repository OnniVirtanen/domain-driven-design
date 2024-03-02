package com.paymentservice.demo.domain;

import com.paymentservice.demo.domain.valueobject.Money;
import com.paymentservice.demo.domain.valueobject.ReadableDate;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
public class MoneyTransaction extends BaseEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID moneyTransactionId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "source_account_id", referencedColumnName = "accountId")
    private Account sourceAccount;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "destination_account_id", referencedColumnName = "accountId")
    private Account destinationAccount;
    @Embedded
    @AttributeOverride(name="value", column=@Column(name="amount"))
    private Money amount;
    @Embedded
    @AttributeOverride(name="value", column=@Column(name="date"))
    private ReadableDate date;
    private String description;

    public MoneyTransaction() {

    }

    public MoneyTransaction(Account sourceAccount, Account destinationAccount, Money amount, String description) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.description = description;
        this.date = new ReadableDate();
    }

    public UUID getMoneyTransactionId() {
        return moneyTransactionId;
    }

    public void setMoneyTransactionId(UUID moneyTransactionId) {
        this.moneyTransactionId = moneyTransactionId;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public ReadableDate getDate() {
        return date;
    }

    public void setDate(ReadableDate date) {
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
        MoneyTransaction that = (MoneyTransaction) o;
        return Objects.equals(moneyTransactionId, that.moneyTransactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneyTransactionId);
    }

}
