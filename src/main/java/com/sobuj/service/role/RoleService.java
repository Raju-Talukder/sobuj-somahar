package com.sobuj.service.role;

import com.sobuj.models.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findById(Long id);
    Role create(Role role);

}
