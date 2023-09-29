package com.paymentservice.demo.account.valueobjects;

import com.paymentservice.demo.domain.account.valueobject.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void validate_negativeAmount_throws() {
        // Arrange
        BigDecimal negativeAmount = new BigDecimal("-1");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Money(negativeAmount));
    }

    @Test
    void validate_zeroAmount_doesNotThrow() {
        // Arrange
        BigDecimal zeroAmount = new BigDecimal("0");

        // Act & Assert
        assertDoesNotThrow(() -> new Money(zeroAmount));
    }

    @Test
    void validate_positiveAmount_doesNotThrow() {
        // Arrange
        BigDecimal positiveAmount = new BigDecimal("1");

        // Act & Assert
        assertDoesNotThrow(() -> new Money(positiveAmount));
    }

    @Test
    void validate_nullAmount_throws() {
        // Arrange & Act & Assert
        assertThrows(NullPointerException.class, () -> new Money(null));
    }

    @Test
    void subtract_resultingInNegativeAmount_throws() {
        // Arrange
        Money minuend = new Money(new BigDecimal("1"));
        Money subtrahend = new Money(new BigDecimal("2"));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> minuend.subtract(subtrahend));
    }

    @Test
    void subtract_resultingInZeroAmount_doesNotThrow() {
        // Arrange
        Money minuend = new Money(new BigDecimal("1"));
        Money subtrahend = new Money(new BigDecimal("1"));

        // Act & Assert
        assertDoesNotThrow(() -> minuend.subtract(subtrahend));
    }

    @Test
    void subtract_resultingInPositiveAmount_doesNotThrow() {
        // Arrange
        Money minuend = new Money(new BigDecimal("2"));
        Money subtrahend = new Money(new BigDecimal("1"));

        // Act & Assert
        assertDoesNotThrow(() -> minuend.subtract(subtrahend));
    }

    @Test
    void subtract_regularScenario_correctAnswer() {
        // Arrange
        Money minuend = new Money(new BigDecimal("2"));
        Money subtrahend = new Money(new BigDecimal("1"));
        Money expected = new Money(new BigDecimal("1"));

        // Act
        Money actual = minuend.subtract(subtrahend);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void add_regularScenario_correctAnswer() {
        // Arrange
        Money summand1 = new Money(new BigDecimal("1"));
        Money summand2 = new Money(new BigDecimal("1"));
        Money expected = new Money(new BigDecimal("2"));

        // Act
        Money actual = summand1.add(summand2);

        //Assert
        assertEquals(expected, actual);
    }
}