package org.example.password;

public class PasswordStrengthCalculator {

    private static final int TOTAL_UPPER_CHARS = 26;
    private static final int TOTAL_LOWER_CHARS = 26;
    private static final int TOTAL_NUMBER_CHARS = 10;
    private static final int TOTAL_SYMBOL_CHARS = 32;

    public static double calculatePasswordStrength(String password, boolean lower, boolean upper, boolean number, boolean symbol) {
        int totalCombination = calculateTotalCombination(lower, upper, number, symbol);
        return Math.round(calculateEntropy(password.length(), totalCombination) * 100.0) / 100.0;
    }

    public static String passwordQuality(double entropy) {
        if (entropy >= 100) {return "Excellent";}
        else if (entropy >= 75) {return "Good";}
        else if (entropy >= 45) {return "Weak";}
        else {return "Poor";}
    }

    private static double calculateLog2(int N) {
        return Math.log(N) / Math.log(2);
    }

    private static double calculateEntropy(int passwordLength, int totalCombination) {
        return passwordLength * calculateLog2(totalCombination);
    }

    private static int calculateTotalCombination(boolean lower, boolean upper, boolean number, boolean symbol) {
        int combination  = 0;
        if (lower) {combination += TOTAL_LOWER_CHARS;}
        if (upper) {combination += TOTAL_UPPER_CHARS;}
        if (number) {combination += TOTAL_NUMBER_CHARS;}
        if (symbol) {combination += TOTAL_SYMBOL_CHARS;}
        return combination;
    }
}
