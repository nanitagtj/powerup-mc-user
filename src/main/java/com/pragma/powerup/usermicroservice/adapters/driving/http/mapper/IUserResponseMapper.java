package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.RoleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    RoleResponseDto roleToRoleResponse(Role role);
    default UserResponseDto userToUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setIdRole(roleToRoleResponse(user.getIdRole()));
        return userResponseDto;
    }

    List<UserResponseDto> userListToUserResponseList(List<User> userList);
}
