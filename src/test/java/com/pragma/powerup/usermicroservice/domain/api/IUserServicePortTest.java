package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class IUserServicePortTest {

    @Test
    void saveOwner() {
        IUserServicePort userServicePort = Mockito.mock(IUserServicePort.class);
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setSurname("Doe");
        user.setMail("john.doe@example.com");
        user.setPhone("+5712345678912");
        user.setDniNumber("1234567890");
        user.setPassword("password");
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_ADMIN");
        user.setIdRole(role);
        user.setBirthDate(LocalDate.of(2000, 1, 1));
        userServicePort.saveOwner(user);

        verify(userServicePort, times(1)).saveOwner(user);
    }
}