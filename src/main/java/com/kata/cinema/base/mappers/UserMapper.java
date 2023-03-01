package com.kata.cinema.base.mappers;

import com.kata.cinema.base.models.dto.response.UserResponseDto;
import com.kata.cinema.base.models.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "fullName", ignore = true)
    @Mapping(target = "avatarUrl", ignore = true)
    UserResponseDto toDTO(User user);

    default List<UserResponseDto> toDTOList(List<User> userList) {
        return userList.stream().map(this::toDTO).toList();
    }

    @AfterMapping
    default void setFullName(@MappingTarget UserResponseDto userResponseDto,
                             User user) {
        userResponseDto.setFullName(user.getFirstName() + ", " +  user.getLastName());
        userResponseDto.setAvatarUrl(user.getAvatarUrl());
    }

}
