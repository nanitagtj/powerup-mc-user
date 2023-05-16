package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.EmptyBirthDateException;
import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.BadRequestException;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import com.pragma.powerup.usermicroservice.domain.validations.Validations;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }
    @Override
    public void createUser(User user) {
        userPersistencePort.createUser(user);
    }
    @Override
    public User getUserById(Long id) {
       return userPersistencePort.getUserById(id);
    }
    @Override
    public Page<User> getAllUsers(Pageable pageable){
        Page<User> listado =  userPersistencePort.getAllUsers(pageable);
        return listado;
    }
    @Override
    public void deleteUser(Long id) {
        userPersistencePort.deleteUser(id);
    }
    public void createOwner(User user) {
        Validations.validateIdDocument(user.getDniNumber());
        Validations.validateAge(user.getBirthDate());
        Role ownerRole = new Role();
        ownerRole.setId(Constants.OWNER_ROLE_ID);
        user.setRole(ownerRole);
        userPersistencePort.createOwner(user);
    }
}
