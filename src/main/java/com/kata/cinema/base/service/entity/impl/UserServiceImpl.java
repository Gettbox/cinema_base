package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.models.entity.User;
import com.kata.cinema.base.repositories.UserRepository;
import com.kata.cinema.base.service.entity.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
