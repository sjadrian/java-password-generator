package org.example.password;

public class PasswordFactory {

    private String password;
    private double passwordStrength;
    private String passwordQuality;
    private final PasswordGenerator passwordGenerator;

    public PasswordFactory() {
        passwordGenerator = new PasswordGenerator();
    }

    public void generatePassword() {
        this.password = passwordGenerator.generatePassword();
        calculatePasswordStrength();
        calculatePasswordQuality();
    }

    public void calculatePasswordStrength() {
        this.passwordStrength = PasswordStrengthCalculator.calculatePasswordStrength(
                password,
                passwordGenerator.getLowerCase(),
                passwordGenerator.getUpperCase(),
                passwordGenerator.getNumber(),
                passwordGenerator.getSymbol());
    }

    public void calculatePasswordQuality() {
        this.passwordQuality = PasswordStrengthCalculator.passwordQuality(passwordStrength);
    }

    public String getPassword() {
        return password;
    }

    public double getPasswordStrength() {
        return passwordStrength;
    }

    public String getPasswordQuality() {
        return passwordQuality;
    }

    public void setCondition(boolean upper, boolean lower, boolean number, boolean symbol, int length) {
        passwordGenerator.setUpperCase(upper);
        passwordGenerator.setLowerCase(lower);
        passwordGenerator.setNumber(number);
        passwordGenerator.setSymbol(symbol);
        passwordGenerator.setLength(length);
    }


}
