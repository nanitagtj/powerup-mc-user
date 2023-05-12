package com.pragma.powerup.usermicroservice.domain.validations;

import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.BadRequestException;
import com.pragma.powerup.usermicroservice.domain.model.User;

import java.time.LocalDate;

public class Validations {

    public static void validateIdDocument(String DniNumber) {
        if (!DniNumber.matches("[0-9]{1,11}")) {
            throw new BadRequestException("ID document must be numeric and have between 1 and 11 digits");
        }
    }
    public static void validateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - birthDate.getYear();
        if (age < 18) {
            throw new BadRequestException("User must be at least 18 years old");
        }
    }

}
