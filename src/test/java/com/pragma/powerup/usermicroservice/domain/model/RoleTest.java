package com.pragma.powerup.usermicroservice.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    public void testRoleGettersAndSetters() {
        Long id = 1L;
        String name = "ADMIN";
        String description = "Administrator role";

        Role role = new Role();
        role.setId(id);
        role.setName(name);
        role.setDescription(description);

        assertEquals(id, role.getId());
        assertEquals(name, role.getName());
        assertEquals(description, role.getDescription());
    }

    @Test
    public void testRoleConstructorWithIdNameAndDescription() {

        Long id = 1L;
        String name = "ADMIN";
        String description = "Administrator role";

        Role role = new Role(id, name, description);

        assertEquals(id, role.getId());
        assertEquals(name, role.getName());
        assertEquals(description, role.getDescription());
    }

}