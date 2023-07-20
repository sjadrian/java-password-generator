package org.example;

import java.util.Random;

public class PasswordGenerator {

    private boolean lowerCase;
    private boolean upperCase;
    private boolean number;
    private boolean symbol;
    private final Random random;
    private int length;
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = LOWER_CASE.toUpperCase();
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";

    public PasswordGenerator() {
        this.random  = new Random();
    }

    public String generatePassword() {
        String possibleCharacters = generatePossibleCharacters();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(possibleCharacters.charAt(random.nextInt(possibleCharacters.length())));
        }
        return password.toString();
    }

    private String generatePossibleCharacters() {
        String returnString = "";
        if (lowerCase) {returnString += LOWER_CASE;}
        if (upperCase) {returnString += UPPER_CASE;}
        if (number) {returnString += NUMBERS;}
        if (symbol) {returnString += SYMBOLS;}

        return returnString;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public void setLowerCase(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }

    public void setSymbol(boolean symbol) {
        this.symbol = symbol;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean getUpperCase() {
        return upperCase;
    }

    public boolean getLowerCase() {
        return lowerCase;
    }

    public boolean getNumber() {
        return number;
    }

    public boolean getSymbol() {
        return symbol;
    }
}
