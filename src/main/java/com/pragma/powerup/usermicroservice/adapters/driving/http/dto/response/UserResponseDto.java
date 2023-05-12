package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.management.relation.Role;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
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
    private Role idRole;
    private LocalDate birthDate;

    public UserResponseDto() {
        
    }

    public void setIdRole(RoleResponseDto roleResponseDto) {
    }
}
