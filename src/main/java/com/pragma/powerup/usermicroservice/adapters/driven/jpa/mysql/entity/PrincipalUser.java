package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import com.pragma.powerup.usermicroservice.domain.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipalUser implements UserDetails {
    private String mail;
    private RoleEntity role;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(String mail, RoleEntity role, String password,
                         Collection<? extends GrantedAuthority> authorities) {

        this.mail = mail;
        this.role = role;
        this.password = password;
        this.authorities = authorities;
    }

    public static PrincipalUser build(UserEntity user, List<RoleEntity> roles) {
        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return new PrincipalUser(user.getMail(), user.getRole(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getMail() {
        return mail;
    }

    public RoleEntity getRole() {
        return role;
    }
}
