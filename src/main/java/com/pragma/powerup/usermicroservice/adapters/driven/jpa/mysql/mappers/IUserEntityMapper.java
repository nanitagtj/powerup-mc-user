package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IUserEntityMapper {
    @Mapping(target = "role", source = "role")
    UserEntity toEntity(User user);
    @Mapping(target = "role", source = "idRole")
    List<User> toUserList(List<UserEntity> userEntityList);

    default Page<User> toUserPage(Page<UserEntity> userEntityPage) {
        List<User> userList = toUserList(userEntityPage.getContent());
        return new PageImpl<>(userList, userEntityPage.getPageable(), userEntityPage.getTotalElements());
    }
    User userEntityToUser(UserEntity userEntity);
}