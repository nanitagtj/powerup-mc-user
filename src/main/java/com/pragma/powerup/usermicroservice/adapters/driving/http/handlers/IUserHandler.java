package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserHandler {
    void createUser(UserRequestDto userRequestDto);
    void createOwner(UserRequestDto userRequestDto);
    void createEmployee(UserRequestDto userRequestDto);
    void createClient(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long id);
    Page<UserResponseDto> getAllUsers(Pageable pageable);
    void deleteUser(Long id);
}
