package com.solvians.showcase.isin;

public final class IsinValidator {

    private IsinValidator() {
    }

    public static boolean isValid(String isin) {
        if (isin == null || isin.length() != 12) return false;
        String body = isin.substring(0, 11);
        char checkChar = isin.charAt(11);
        if (!Character.isDigit(checkChar)) return false;
        int expected = calculateCheckDigit(body);
        int actual = Character.getNumericValue(checkChar);
        return expected == actual;
    }

    public static int calculateCheckDigit(String body) {
        StringBuilder expanded = new StringBuilder();
        for (char c : body.toCharArray()) {
            if (Character.isLetter(c)) {
                expanded.append((c - 'A') + 10);
            } else {
                expanded.append(c);
            }
        }
        int sum = 0;
        boolean doubleIt = true;
        for (int i = expanded.length() - 1; i >= 0; i--) {
            int n = expanded.charAt(i) - '0';
            if (doubleIt) {
                n *= 2;
                if (n > 9) n -= 9;
            }
            sum += n;
            doubleIt = !doubleIt;
        }
        int mod = sum % 10;
        return mod == 0 ? 0 : 10 - mod;
    }
}
