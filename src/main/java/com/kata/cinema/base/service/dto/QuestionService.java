package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.request.QuestionRequestDto;

import java.util.List;

public interface QuestionService {

    void createQuestion(Long id, List<QuestionRequestDto> list);

    void deleteQuestion(Long news_id, Long quest_id);
}
