package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserPersistencePort {
    void createOwner(User user);
    void createUser(User user);
    User getUserById(Long id);
    Page<User> getAllUsers(Pageable pageable);
    void deleteUser(Long id);
}
