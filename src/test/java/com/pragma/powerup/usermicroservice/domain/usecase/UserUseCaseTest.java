package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private IUserPersistencePort userPersistencePort;


    @InjectMocks
    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOwner() {
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setSurname("Doe");
        user.setMail("john.doe@example.com");
        user.setPhone("1234567890");
        user.setDniNumber("123456789");
        user.setPassword("mypassword");
        user.setRole(new Role(1L, "ADMIN", "ADMIN"));
        user.setBirthDate(LocalDate.of(1990, 5, 20));
        userUseCase.createOwner(user);
        verify(userPersistencePort, times(1)).createOwner(user);
    }
}