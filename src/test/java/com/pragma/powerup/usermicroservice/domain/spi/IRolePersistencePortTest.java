package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IRolePersistencePortTest {

    private IRolePersistencePort rolePersistencePort;
    private List<Role> mockRoles;

    @BeforeEach
    void setUp() {
        rolePersistencePort = mock(IRolePersistencePort.class);
        mockRoles = createMockRoles();
    }
    @Test
    void getAllRoles() {
        when(rolePersistencePort.getAllRoles()).thenReturn(mockRoles);
        List<Role> roles = rolePersistencePort.getAllRoles();
        Assertions.assertEquals(mockRoles.size(), roles.size());
        for (int i = 0; i < mockRoles.size(); i++) {
            Assertions.assertEquals(mockRoles.get(i), roles.get(i));
        }
        verify(rolePersistencePort, times(1)).getAllRoles();
    }

    private List<Role> createMockRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L));
        roles.add(new Role(2L));
        roles.add(new Role(3L));
        return roles;
    }
}