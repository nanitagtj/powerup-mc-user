package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El Nit es obligatorio")
    @Pattern(regexp = "\\d+", message = "El Nit debe ser numérico")
    private String nit;

    @NotBlank(message = "La dirección es obligatoria")
    private String address;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\+\\d{1,12}", message = "El teléfono debe tener el formato + seguido de hasta 12 dígitos")
    private String phone;

    @NotBlank(message = "La URL del logo es obligatoria")
    private String urlLogo;

    @NotNull(message = "El ID del propietario es obligatorio")
    private Long idOwner;
}
