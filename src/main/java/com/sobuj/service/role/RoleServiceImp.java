package com.sobuj.service.role;

import com.sobuj.models.Role;
import com.sobuj.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }
}
