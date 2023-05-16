package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserEntityTest {
    @Test
    public void UserEntityGettersAndSetters() {
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        String mail = "john.doe@example.com";
        String phone = "123456789";
        String dniNumber = "123456789";
        String password = "password";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        RoleEntity role = mock(RoleEntity.class);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(name);
        userEntity.setSurname(surname);
        userEntity.setMail(mail);
        userEntity.setPhone(phone);
        userEntity.setDniNumber(dniNumber);
        userEntity.setPassword(password);
        userEntity.setBirthDate(birthDate);
        userEntity.setRole(role);

        assertEquals(id, userEntity.getId());
        assertEquals(name, userEntity.getName());
        assertEquals(surname, userEntity.getSurname());
        assertEquals(mail, userEntity.getMail());
        assertEquals(phone, userEntity.getPhone());
        assertEquals(dniNumber, userEntity.getDniNumber());
        assertEquals(password, userEntity.getPassword());
        assertEquals(birthDate, userEntity.getBirthDate());
        assertEquals(role, userEntity.getRole());
    }

    @Test
    public void UserEntityConstructor() {
        // Arrange
        Long id = 1L;
        String name = "John";
        String surname = "Doe";
        String mail = "john.doe@example.com";
        String phone = "123456789";
        String dniNumber = "123456789";
        String password = "password";
        Optional<LocalDate> birthDate = Optional.of(LocalDate.of(1990, 1, 1));

        RoleEntity role = mock(RoleEntity.class);

        UserEntity userEntity = new UserEntity(id, name, surname, mail, phone, dniNumber, password, role, birthDate);

        assertEquals(id, userEntity.getId());
        assertEquals(name, userEntity.getName());
        assertEquals(surname, userEntity.getSurname());
        assertEquals(mail, userEntity.getMail());
        assertEquals(phone, userEntity.getPhone());
        assertEquals(dniNumber, userEntity.getDniNumber());
        assertEquals(password, userEntity.getPassword());
        assertEquals(birthDate, userEntity.getBirthDate());
        assertEquals(role, userEntity.getRole());
    }

    @Test
    public void testUserEntityRoleRelationship() {

        RoleEntity role = new RoleEntity(1L, "ROLE_ADMIN", "User Role");
        UserEntity userEntity = new UserEntity();
        userEntity.setRole(role);

        RoleEntity actualRole = userEntity.getRole();

        assertNotNull(actualRole);
        assertEquals(role.getId(), actualRole.getId());
        assertEquals(role.getName(), actualRole.getName());
        assertEquals(role.getDescription(), actualRole.getDescription());
    }

}