package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IUserPersistencePortTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveOwner_ValidUser_CallsRepositorySave() {
        User user = new User();
        IUserPersistencePort userPersistencePort = mock(IUserPersistencePort.class);
        userPersistencePort.createOwner(user);
        verify(userPersistencePort, times(1)).createOwner(user);
    }

    @Test
    void saveOwner_ValidUser_CallsRepositorySaveWithCorrectUser() {
        User user = new User();
        IUserPersistencePort userPersistencePort = mock(IUserPersistencePort.class);
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        userPersistencePort.createOwner(user);
        verify(userPersistencePort, times(1)).createOwner(userCaptor.capture());
        User capturedUser = userCaptor.getValue();
        assertEquals(user, capturedUser);
    }
}