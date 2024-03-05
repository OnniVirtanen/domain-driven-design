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

    public Person() {}

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public ReadableDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(ReadableDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SocialSecurityNumber getSsn() {
        return ssn;
    }

    public void setSsn(SocialSecurityNumber ssn) {
        this.ssn = ssn;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isUnderSanctions() {
        return underSanctions;
    }

    public void setUnderSanctions(boolean underSanctions) {
        this.underSanctions = underSanctions;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
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
