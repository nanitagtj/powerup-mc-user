package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserResponseMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public void createUser(UserRequestDto userRequestDto) {
        User user = userRequestMapper.toDomain(userRequestDto);
        userServicePort.createUser(user);
    }
    @Override
    public void createOwner(UserRequestDto userRequestDto) {
        User owner = userRequestMapper.toDomain(userRequestDto);
        userServicePort.createOwner(owner);
    }
    @Override
    public void createEmployee(UserRequestDto userRequestDto) {
        User employee = userRequestMapper.toDomain(userRequestDto);
        userServicePort.createEmployee(employee);
    }
    @Override
    public void createClient(UserRequestDto userRequestDto) {
        User client = userRequestMapper.toDomain(userRequestDto);
        userServicePort.createClient(client);
    }
    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userServicePort.getUserById(id);
        return userResponseMapper.toResponse(user);
    }
    @Override
    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        Page<User> users = userServicePort.getAllUsers(pageable);
        return users.map(userResponseMapper::toResponse);
    }
    @Override
    public void deleteUser(Long id) {
        userServicePort.deleteUser(id);
    }
}
