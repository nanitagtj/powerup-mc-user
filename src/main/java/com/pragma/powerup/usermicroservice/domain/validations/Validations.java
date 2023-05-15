package com.pragma.powerup.usermicroservice.domain.validations;

public class Validations {

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        boolean containsLetter = false;
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c)) {
                containsLetter = true;
                break;
            }
        }

        if (!containsLetter) {
            throw new IllegalArgumentException("El nombre no puede ser solo numérico");
        }
    }
}
