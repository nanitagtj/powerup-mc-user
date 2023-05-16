package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserServicePort {
    void createUser(User user);
    void createOwner(User user);
    User getUserById(Long id);
    Page<User> getAllUsers(Pageable pageable);
    void deleteUser(Long id);
}
