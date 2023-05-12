package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleEntityTest {
    @Test
    public void RoleEntityConstructorAndGetters() {
        Long Id = 1L;
        String Name = "ROLE_ADMIN";
        String Description = "Admin Role";

        RoleEntity roleEntity = new RoleEntity(Id, Name, Description);

        assertNotNull(roleEntity);
        assertEquals(Id, roleEntity.getId());
        assertEquals(Name, roleEntity.getName());
        assertEquals(Description, roleEntity.getDescription());
    }

    @Test
    public void RoleEntitySettersAndGetters() {
        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId(1L);
        roleEntity.setName("ROLE_ADMIN");
        roleEntity.setDescription("Admin Role");

        assertEquals(1L, roleEntity.getId());
        assertEquals("ROLE_ADMIN", roleEntity.getName());
        assertEquals("Admin Role", roleEntity.getDescription());
    }

}