package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import com.pragma.powerup.usermicroservice.domain.validations.Validations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void createUser(User user) {
        Validations.validateIdDocument(user.getDniNumber());
        Validations.validateAge(user.getBirthDate());
        userPersistencePort.createUser(user);
    }
    public void createOwner(User owner) {
        Validations.validateIdDocument(owner.getDniNumber());
        Validations.validateAge(owner.getBirthDate());
        Role role = rolePersistencePort.getRoleById(Constants.OWNER_ROLE_ID);
        owner.setRole(role);
        userPersistencePort.createOwner(owner);
    }

    public void createEmployee(User employee) {
        Validations.validateIdDocument(employee.getDniNumber());
        Validations.validateAge(employee.getBirthDate());
        Role role = rolePersistencePort.getRoleById(Constants.EMPLOYEE_ROLE_ID);
        employee.setRole(role);
        userPersistencePort.createEmployee(employee);
    }
    public void createClient(User client) {
        Validations.validateIdDocument(client.getDniNumber());
        Validations.validateAge(client.getBirthDate());
        Role role = rolePersistencePort.getRoleById(Constants.CLIENT_ROLE_ID);
        client.setRole(role);
        userPersistencePort.createClient(client);
    }


    @Override
    public User getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable){
        Page<User> userList =  userPersistencePort.getAllUsers(pageable);
        return userList;
    }

    @Override
    public void deleteUser(Long id) {
        userPersistencePort.deleteUser(id);
    }
}
