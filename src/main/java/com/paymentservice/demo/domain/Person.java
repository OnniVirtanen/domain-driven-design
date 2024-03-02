package com.paymentservice.demo.domain;

import com.paymentservice.demo.domain.valueobject.Address;
import com.paymentservice.demo.domain.valueobject.FullName;
import com.paymentservice.demo.domain.valueobject.PhoneNumber;
import com.paymentservice.demo.domain.valueobject.ReadableDate;
import com.paymentservice.demo.domain.valueobject.SocialSecurityNumber;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Person extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;
    @Embedded
    private FullName name;
    @Embedded
    @AttributeOverride(name="value", column=@Column(name="date_of_birth"))
    private ReadableDate dateOfBirth;
    @OneToOne(mappedBy = "accountHolder")
    private Account account;
    @Embedded
    @AttributeOverride(name="value", column=@Column(name="social_security_number"))
    private SocialSecurityNumber ssn;
    @Embedded
    @AttributeOverride(name="value", column=@Column(name="phone_number"))
    private PhoneNumber phoneNumber;
    @Embedded
    private Address address;

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
