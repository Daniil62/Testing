package ru.job4j.testing;

public interface Validator<T> {
    boolean validate(T value);
    int counter(T value);
}
