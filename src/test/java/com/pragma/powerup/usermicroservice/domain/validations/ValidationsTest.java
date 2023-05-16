package com.pragma.powerup.usermicroservice.domain.validations;

import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.BadRequestException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void validateIdDocument_ValidId_DoesNotThrowException() {
        String validId = "123456789";
        assertDoesNotThrow(() -> Validations.validateIdDocument(validId));
    }

    @Test
    void validateIdDocument_InvalidId_ThrowsBadRequestException() {
        String invalidId = "abc123";
        assertThrows(BadRequestException.class, () -> Validations.validateIdDocument(invalidId));
    }

}