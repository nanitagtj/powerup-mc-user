package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestDtoTest {
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();
    LocalDate birthDate = LocalDate.of(1990, 1, 1);

    @Test
    void userRequestDto_ValidFields_ValidatedSuccessfully() {
        UserRequestDto userRequestDto = new UserRequestDto(
                "123456789",
                "test@example.com",
                "John",
                "password",
                "+123456789",
                "Doe",
                2L,
                birthDate
        );

        var violations = validator.validate(userRequestDto);

        assertTrue(violations.isEmpty());
    }

    @Test
    void userRequestDto_InvalidDniNumber_ValidationFails() {

        UserRequestDto userRequestDto = new UserRequestDto(
                "invalid",
                "test@example.com",
                "John",
                "password",
                "+123456789",
                "Doe",
                2L,
                birthDate
        );

        var violations = validator.validate(userRequestDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Dni must be numeric", violations.iterator().next().getMessage());
        assertEquals("dniNumber", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void userRequestDto_InvalidEmail_ValidationFails() {
        UserRequestDto userRequestDto = new UserRequestDto(
                "123456789",
                "invalid",
                "John",
                "password",
                "+123456789",
                "Doe",
                2L,
                birthDate
        );

        var violations = validator.validate(userRequestDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("must be a well-formed email address", violations.iterator().next().getMessage());
        assertEquals("mail", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void userRequestDto_MissingName_ValidationFails() {
        UserRequestDto userRequestDto = new UserRequestDto(
                "123456789",
                "test@example.com",
                null,
                "password",
                "+123456789",
                "Doe",
                2L,
                birthDate
        );

        var violations = validator.validate(userRequestDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void userRequestDto_MissingPhone_ValidationFails() {

        UserRequestDto userRequestDto = new UserRequestDto(
                "123456789",
                "test@example.com",
                "John",
                "password",
                "+123456789",
                null,
                2L,
                birthDate
        );

        var violations = validator.validate(userRequestDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("must not be blank", violations.iterator().next().getMessage());
        assertEquals("phone", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void userRequestDto_InvalidPhoneFormat_ValidationFails() {

        UserRequestDto userRequestDto = new UserRequestDto(
                "123456789",
                "test@example.com",
                "John",
                "password",
                "+abc456789",
                "Doe",
                2L,
                birthDate
        );

        var violations = validator.validate(userRequestDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("Invalid phone number format", violations.iterator().next().getMessage());
        assertEquals("phone", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void userRequestDto_MissingSurname_ValidationFails() {
        UserRequestDto userRequestDto = new UserRequestDto(
                "123456789",
                "test@example.com",
                "John",
                "password",
                "+123456789",
                null,
                2L,
                birthDate
        );

        var violations = validator.validate(userRequestDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
        assertEquals("surname", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void userRequestDto_ValidRequest_ValidatesSuccessfully() {
        UserRequestDto userRequestDto = new UserRequestDto(
                "123456789",
                "test@example.com",
                "John",
                "password",
                "+123456789",
                "Doe",
                2L,
                birthDate
        );

        var violations = validator.validate(userRequestDto);

        assertTrue(violations.isEmpty());

    }

}