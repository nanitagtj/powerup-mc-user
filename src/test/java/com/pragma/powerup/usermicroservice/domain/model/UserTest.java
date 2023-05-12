package com.pragma.powerup.usermicroservice.domain.model;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testConstructorAndGetters() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        String mail = "john.doe@example.com";
        String phone = "123456789";
        String dniNumber = "12345678";
        String password = "password";
        Role role = new Role(1L);
        LocalDate birthDate = LocalDate.of(1990, 1, 1);

        User user = new User(id, name, surname, mail, phone, dniNumber, password, role, birthDate);

        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(surname, user.getSurname());
        assertEquals(mail, user.getMail());
        assertEquals(phone, user.getPhone());
        assertEquals(dniNumber, user.getDniNumber());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getIdRole());
        assertEquals(birthDate, user.getBirthDate());
    }

    @Test
    public void testSetters() {
        User user = new User();

        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        String mail = "john.doe@example.com";
        String phone = "123456789";
        String dniNumber = "12345678";
        String password = "password";
        Role role = new Role(1L);
        LocalDate birthDate = LocalDate.of(1990, 1, 1);

        user.setId(id);
        user.setName(name);
        user.setSurname(surname);
        user.setMail(mail);
        user.setPhone(phone);
        user.setDniNumber(dniNumber);
        user.setPassword(password);
        user.setIdRole(role);
        user.setBirthDate(birthDate);

        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(surname, user.getSurname());
        assertEquals(mail, user.getMail());
        assertEquals(phone, user.getPhone());
        assertEquals(dniNumber, user.getDniNumber());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getIdRole());
        assertEquals(birthDate, user.getBirthDate());
    }
}