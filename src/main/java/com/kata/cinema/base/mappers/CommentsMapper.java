package com.kata.cinema.base.mappers;

import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entity.Comments;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentsMapper {

    CommentsMapper INSTANCE = Mappers.getMapper(CommentsMapper.class);

    CommentsResponseDto toDTO(Comments comments);

    List<CommentsResponseDto> modelsToDTO(List<Comments> comments);

    Comments toEntity(CommentsResponseDto commentsResponseDto);
}
