package ru.job4j.testing;

public class EmailValidator implements Validator<String> {
    @Override
    public boolean validate(String value) {
        return value.length() >= 9 && value.contains("@");
    }
    @Override
    public int counter(String value) {
        return value.length();
    }
}
