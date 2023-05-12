package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IRoleServicePortTest {
    @Mock
    private IRoleServicePort roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRoles() {
        List<Role> expectedRoles = createMockRoles();
        when(roleService.getAllRoles()).thenReturn(expectedRoles);
        List<Role> actualRoles = roleService.getAllRoles();
        assertEquals(expectedRoles, actualRoles);
    }

    private List<Role> createMockRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, "Admin"));
        roles.add(new Role(2L, "Owner"));
        return roles;
    }

}