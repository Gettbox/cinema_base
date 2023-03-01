package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.mappers.UserMapper;
import com.kata.cinema.base.models.dto.response.UserResponseDto;
import com.kata.cinema.base.repositories.UserRepository;
import com.kata.cinema.base.service.dto.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserDtoServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserDtoServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDto> searchByEmail(String email) {
        return userMapper.toDTOList(userRepository.findAllByEmailContainingIgnoreCase(email));
    }
}
