package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IUserRepositoryTest {

    @Mock
    private IUserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void findByDniNumber_ShouldReturnUser() {
        String dniNumber = "123456789";
        UserEntity user = new UserEntity();
        user.setDniNumber(dniNumber);
        when(userRepository.findByDniNumber(dniNumber)).thenReturn(Optional.of(user));

        Optional<UserEntity> result = userRepository.findByDniNumber(dniNumber);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(dniNumber, result.get().getDniNumber());

        verify(userRepository, times(1)).findByDniNumber(dniNumber);
    }

    @Test
    public void findByDniNumber_WhenUserNotFound_ShouldReturnEmptyOptional() {
        String dniNumber = "123456789";
        when(userRepository.findByDniNumber(dniNumber)).thenReturn(Optional.empty());

        Optional<UserEntity> result = userRepository.findByDniNumber(dniNumber);

        Assertions.assertFalse(result.isPresent());

        verify(userRepository, times(1)).findByDniNumber(dniNumber);
    }

    @Test
    public void existsByMail_ShouldReturnTrue() {
        String mail = "test@example.com";
        when(userRepository.existsByMail(mail)).thenReturn(true);

        boolean result = userRepository.existsByMail(mail);

        Assertions.assertTrue(result);

        verify(userRepository, times(1)).existsByMail(mail);
    }

    @Test
    public void existsByMail_ShouldReturnFalse() {
        String mail = "nonexistent@example.com";
        when(userRepository.existsByMail(mail)).thenReturn(false);

        boolean result = userRepository.existsByMail(mail);

        Assertions.assertFalse(result);

        verify(userRepository, times(1)).existsByMail(mail);
    }

}