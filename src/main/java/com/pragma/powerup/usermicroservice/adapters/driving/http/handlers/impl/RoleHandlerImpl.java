package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.RoleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IRoleHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IRoleResponseMapper;
import com.pragma.powerup.usermicroservice.domain.api.IRoleServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleHandlerImpl implements IRoleHandler {
    private final IRoleResponseMapper roleResponseMapper;
    private final IRoleServicePort roleServicePort;

    @Override
    public Role getRoleById(Long id) {
        return roleServicePort.getRoleById(id);
    }
    @Override
    public Page<RoleResponseDto> getAllRoles(Pageable pageable) {
        Page<Role> roles = roleServicePort.getAllRoles(pageable);
        return roles.map(roleResponseMapper::roleToRoleResponseDto);
    }
}
