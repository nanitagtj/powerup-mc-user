package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRolePersistencePort {
    Role getRoleById(Long id);
    Page<Role> getAllRoles(Pageable pageable);
}
