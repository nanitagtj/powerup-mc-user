package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.Role;

public interface IUserHandler {
    void saveOwner(UserRequestDto userRequestDto);
}
