package com.example.demo.model;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testEmailAddressNotNull() {
        User user = new User();
        user.setPassword("password123");

        var violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("メールアドレスを入力してください。")));
    }

    @Test
    public void testPasswordNotNull() {
        User user = new User();
        user.setEmailAddress("test@example.com");

        var violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("パスワードを入力してください。")));
    }
}
