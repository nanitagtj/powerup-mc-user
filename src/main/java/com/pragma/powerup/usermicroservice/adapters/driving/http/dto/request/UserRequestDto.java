package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    @Pattern(regexp = "^[0-9]+$", message = "Dni must be numeric")
    @NotBlank
    private String dniNumber;
    @Email
    @NotBlank
    private String mail;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @Pattern(regexp = "\\+\\d{1,12}", message = "Invalid phone number format")
    @NotBlank
    private String phone;
    @NotBlank
    private String surname;
    @NotNull
    private LocalDate birthDate;

    public UserRequestDto(String number, String mail, String john, String password, String s, String doe, long l, LocalDate birthDate) {
    }
}
