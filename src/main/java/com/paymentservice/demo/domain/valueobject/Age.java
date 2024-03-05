package com.paymentservice.demo.domain.valueobject;

import com.paymentservice.demo.domain.base.ValueObject;

import java.util.Objects;

public final class Age extends ValueObject {

    private final short age;

    public Age(short age) {
        if (!isValidAge(age)) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
    }

    public short getAge() {
        return age;
    }

    private static boolean isValidAge(short age) {
        return age <= 150 && age > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Age age1 = (Age) o;
        return age == age1.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

}
