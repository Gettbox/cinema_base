package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> searchByEmail(String email);
}