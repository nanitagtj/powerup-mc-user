package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"mail", "dni_number"})})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "surname")
    private String surname;
    @NotNull
    @Column(name = "mail")
    private String mail;
    @NotNull
    @Column(name = "phone")
    private String phone;
    @NotNull
    @Column(name = "dni_number")
    private String dniNumber;
    @NotNull
    @Column(name = "password")
    private String password;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private RoleEntity role;
    @Column(name = "birth_date")
    private LocalDate birthDate;

}
