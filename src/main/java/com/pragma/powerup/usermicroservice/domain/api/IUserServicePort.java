package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserServicePort {

    void createUser(User user);
    void createOwner(User owner);
    void createEmployee(User employee);
    void createClient(User client);
    User getUserById(Long id);
    Page<User> getAllUsers(Pageable pageable);
    void deleteUser(Long id);
}
