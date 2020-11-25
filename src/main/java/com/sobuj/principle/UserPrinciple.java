package com.sobuj.principle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sobuj.models.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String photo;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    public UserPrinciple() {
    }
    public UserPrinciple(String name, String photo,String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    public static UserDetails create(Account m) {
        List<GrantedAuthority> authorities = m.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return new UserPrinciple(
                m.getName(),
                m.getPhoto(),
                m.getEmail(),
                m.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
}
