package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestDtoTest {
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    void loginRequestDto_ValidFields_ValidatedSuccessfully() {

        LoginRequestDto loginRequestDto = new LoginRequestDto("test@example.com", "password");

        var violations = validator.validate(loginRequestDto);

        assertTrue(violations.isEmpty());
    }
    @Test
    void loginRequestDto_MissingMail_ValidationFails() {

        LoginRequestDto loginRequestDto = new LoginRequestDto("", "password");

        var violations = validator.validate(loginRequestDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("must not be blank", violations.iterator().next().getMessage());
        assertEquals("mail", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void loginRequestDto_MissingPassword_ValidationFails() {
        LoginRequestDto loginRequestDto = new LoginRequestDto("test@example.com", "");

        var violations = validator.validate(loginRequestDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("must not be blank", violations.iterator().next().getMessage());
        assertEquals("password", violations.iterator().next().getPropertyPath().toString());
    }

}