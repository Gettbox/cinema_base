package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.models.entity.Role;
import com.kata.cinema.base.repositories.RoleRepository;
import com.kata.cinema.base.service.entity.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public Role getByName(String name) {
        return roleRepository.getByName(name);
    }
}
