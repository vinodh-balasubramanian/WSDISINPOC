package com.solvians.showcase.isin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class IsinTest {

    @Test
    void shouldRejectInvalidIsin() {
        assertThrows(IllegalArgumentException.class, () -> new Isin("DE1234567890"));
    }

    @Test
    void shouldCreateValidIsin() {
        Isin isin = new Isin("DE1234567896");
        assertEquals("DE1234567896", isin.getValue());
    }

    @Test
    void equalityShouldWork() {
        Isin i1 = new Isin("DE1234567896");
        Isin i2 = new Isin("DE1234567896");
        assertEquals(i1, i2);
        assertEquals(i1.hashCode(), i2.hashCode());
    }
}
