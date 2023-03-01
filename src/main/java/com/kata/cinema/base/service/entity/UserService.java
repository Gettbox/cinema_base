package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entity.User;

public interface UserService {

    void save(User user);

    User getById(Long id);
}
