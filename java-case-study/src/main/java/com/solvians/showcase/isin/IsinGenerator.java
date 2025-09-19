package com.solvians.showcase.isin;

import java.util.Locale;
import java.util.Random;

public class IsinGenerator {

    private final Random random;
    private static final String[] COUNTRY_CODES = Locale.getISOCountries();

    public IsinGenerator(Random random) {
        this.random = random;
    }

    public Isin generate() {
        String country = COUNTRY_CODES[random.nextInt(COUNTRY_CODES.length)];
        StringBuilder base = new StringBuilder(country);
        generateNumbers(base);
        int checkDigit = IsinValidator.calculateCheckDigit(base.toString());
        base.append(checkDigit);
        return new Isin(base.toString());
    }

    private void generateNumbers(StringBuilder base) {
        for (int i = 0; i < 9; i++) {
            base.append(random.nextInt(10));
        }
    }
}
