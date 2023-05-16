package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    @NotNull
    private String dniNumber;
    @Email
    @NotNull
    private String mail;
    @NotNull
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private String surname;
    @NotNull
    private Long idRole;
    @NotNull
    private LocalDate birthDate;

    public UserResponseDto() {

    }


}
