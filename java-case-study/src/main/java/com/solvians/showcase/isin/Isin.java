package com.solvians.showcase.isin;

import java.util.Objects;

public final class Isin {

    private final String value;

    public Isin(String value) {
        if (!IsinValidator.isValid(value)) {
            throw new IllegalArgumentException("invalid iSIN: " + value);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Isin)) return false;
        Isin other = (Isin) o;
        return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
