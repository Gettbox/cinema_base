package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.response.ScoreResponseDto;
import com.kata.cinema.base.models.entity.Score;

import java.util.List;

public interface ScoreService {
    void save(ScoreResponseDto scoreResponseDto);
    ScoreResponseDto findById(Long id);
    void deleteById(Long id);
    void save(Score score);
    List<Score> getAll();
}
