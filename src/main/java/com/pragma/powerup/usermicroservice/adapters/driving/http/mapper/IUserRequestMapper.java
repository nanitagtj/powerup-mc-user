package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.RoleRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import static com.pragma.powerup.usermicroservice.configuration.Constants.OWNER_ROLE_ID;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {
    @Mapping(target = "role", source = "idRol", qualifiedByName = "mapRole")
    User toDomain(UserRequestDto userRequestDto);
    @Named("mapRole")
    default Role mapRole(Long idRol) {
        Role role = new Role();
        role.setId(idRol);
        return role;
    }

    UserRequestDto toDto(User user);

}
