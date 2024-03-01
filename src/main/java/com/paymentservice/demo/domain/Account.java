package com.paymentservice.demo.domain;


import com.paymentservice.demo.valueobject.Money;
import jakarta.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Embedded
    @Column(name = "balance")
    private Money balance;

    @Column(name = "frozen")
    private Boolean frozen;

    public Account() {

    }

    public Account(Long id, Money balance, Boolean frozen) {
        this.id = id;
        this.balance = balance;
        this.frozen = frozen;
    }

    public Account(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

}
