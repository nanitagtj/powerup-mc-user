package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleUseCaseTest {

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @InjectMocks
    private RoleUseCase roleUseCase;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRoles() {
        Role role1 = new Role(1L, "ADMIN");
        Role role2 = new Role(2L, "OWNER");
        List<Role> roles = Arrays.asList(role1, role2);
        when(rolePersistencePort.getAllRoles()).thenReturn(roles);
        List<Role> result = roleUseCase.getAllRoles();
        assertEquals(roles, result);
        verify(rolePersistencePort, times(1)).getAllRoles();
    }
}