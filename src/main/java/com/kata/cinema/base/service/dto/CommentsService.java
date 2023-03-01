package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.CommentsResponseDto;

import java.util.List;

public interface CommentsService {

    List<CommentsResponseDto> getAllCommentsByDate(Long id);

    List<CommentsResponseDto> getCommentsByDate(Long id);

    void createComment(CommentsResponseDto commentsResponseDto);
}
