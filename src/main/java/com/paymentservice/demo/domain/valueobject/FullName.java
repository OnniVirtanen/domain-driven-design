package com.paymentservice.demo.domain.valueobject;

import jakarta.persistence.Embeddable;

import java.util.Arrays;
import java.util.Objects;

@Embeddable
public class FullName {

    private String firstName;
    private String lastName;
    private String[] otherNames;

    public FullName(String firstName, String lastName, String[] otherNames) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherNames = otherNames;
    }

    protected FullName() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String[] getOtherNames() {
        return otherNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(firstName, fullName.firstName)
                && Objects.equals(lastName, fullName.lastName)
                && Arrays.equals(otherNames, fullName.otherNames);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName);
        result = 31 * result + Arrays.hashCode(otherNames);
        return result;
    }

}


