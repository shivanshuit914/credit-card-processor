package com.example.creditcardprocessor.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnValidatorTest {

    private LuhnValidator luhnValidator;

    @BeforeEach
    void setUp() {
        luhnValidator = new LuhnValidator();
    }

    @Test
    public void wrongCardNumber() {
        assertFalse(luhnValidator.validate("222222222"));
    }

    @Test
    public void cardNumberMoreThanNineteenDigit() {
        assertFalse(luhnValidator.validate("12345678912345678912345"));
    }

    @Test
    public void validCardNumber() {
        assertTrue(luhnValidator.validate("13404354353534544"));
    }
}