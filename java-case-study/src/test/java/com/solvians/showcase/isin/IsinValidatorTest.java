package com.solvians.showcase.isin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsinValidatorTest {

    @Test
    void shouldValidateKnownValidIsin() {
        assertTrue(IsinValidator.isValid("DE1234567896"));
    }

    @Test
    void shouldRejectInvalidCheckDigit() {
        assertFalse(IsinValidator.isValid("DE1234567890"));
    }

    @Test
    void shouldCalculateCheckDigitCorrectly() {
        int checkDigit = IsinValidator.calculateCheckDigit("DE123456789");
        assertEquals(6, checkDigit);
    }
}
