package com.paymentservice.demo.domain.valueobject;

import com.paymentservice.demo.domain.base.ValueObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class ReadableDate extends ValueObject {

    private final String value;

    public ReadableDate(String value) {
        if (!isValidDateFormat(value)) {
            throw new IllegalArgumentException("Invalid date format. It should be ddmmyyyy.");
        }
        this.value = value;
    }

    public ReadableDate() {
        this(LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")));
    }

    public String getValue() {
        return value;
    }

    public LocalDate toDate() {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("ddMMyyyy"));
    }

    private boolean isValidDateFormat(String date) {
        return date.matches("\\d{8}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadableDate dayMonthYear = (ReadableDate) o;
        return Objects.equals(value, dayMonthYear.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}