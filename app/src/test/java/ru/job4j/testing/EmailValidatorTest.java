package ru.job4j.testing;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidatorTest {
    private Validator<String> validator;
    @Before
    public void before() {
        validator = new EmailValidator();
    }
    @Test
    public void whenEmailNotValid() {
        String email = "";
        assertThat(validator.validate(email)).isFalse();
    }
    @Test
    public void whenEmailValid() {
        String email = "my_email@email";
        assertThat(validator.validate(email)).isTrue();
    }
    @Test
    public void whenEmailDoNotContainsSymbol() {
        String email = "my_email.email";
        assertThat(validator.validate(email)).isFalse();
    }
    @Test
    public void whenEmailHasLessThanNineSymbols() {
        String email = "@mail.ru";
        assertThat(validator.validate(email)).isFalse();
    }
    @Test
    public void whenMessageContains19symbols() {
        String message = "Errare humanum est.";
        assertThat(validator.counter(message)).isIn(19);
    }
    @Test
    public void whenMessageContains47symbols() {
        String message = "Ex parvis saepe magnarum rerum momenta pendent.";
        assertThat(validator.counter(message)).isIn(47);
    }
}