package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.RoleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IRoleHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleRestControllerTest {
    @Mock
    private IRoleHandler roleHandler;

    private RoleRestController roleRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        roleRestController = new RoleRestController(roleHandler);
    }

    @Test
    void getAllRoles_ReturnsAllRoles() {

        List<RoleResponseDto> roles = Arrays.asList(
                new RoleResponseDto("ADMIN", "Role 1"),
                new RoleResponseDto("OWNER", "Role 2")
        );
        when(roleHandler.getAllRoles()).thenReturn(roles);

        ResponseEntity<List<RoleResponseDto>> response = roleRestController.getAllRoles();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(roles, response.getBody());
        verify(roleHandler, times(1)).getAllRoles();
    }
}