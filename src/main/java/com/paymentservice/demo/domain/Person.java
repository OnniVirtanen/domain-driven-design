package com.paymentservice.demo.domain;

import com.paymentservice.demo.domain.base.Entity;
import com.paymentservice.demo.domain.valueobject.Address;
import com.paymentservice.demo.domain.valueobject.Age;
import com.paymentservice.demo.domain.valueobject.FullName;
import com.paymentservice.demo.domain.valueobject.PhoneNumber;
import com.paymentservice.demo.domain.valueobject.ReadableDate;
import com.paymentservice.demo.domain.valueobject.SocialSecurityNumber;

import java.util.Objects;

public class Person extends Entity {

    private long personId;
    private FullName name;
    private ReadableDate dateOfBirth;
    private Account account;
    private SocialSecurityNumber ssn;
    private PhoneNumber phoneNumber;
    private Address address;
    private boolean underSanctions;
    private Age age;

    public Person(long personId, FullName name, ReadableDate dateOfBirth, Account account, SocialSecurityNumber ssn,
                  PhoneNumber phoneNumber, Address address, boolean underSanctions, Age age) {
        this.personId = personId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.account = account;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.underSanctions = underSanctions;
        this.age = age;
    }

    public long getPersonId() {
        return personId;
    }

    public FullName getName() {
        return name;
    }

    public ReadableDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Account getAccount() {
        return account;
    }

    public SocialSecurityNumber getSsn() {
        return ssn;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isUnderSanctions() {
        return underSanctions;
    }

    public Age getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }

}
