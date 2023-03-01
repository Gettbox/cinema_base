package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entity.Role;

public interface RoleService {

    void save(Role role);

    Role getByName(String name);
}
