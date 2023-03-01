package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entity.Genre;

import java.util.List;

public interface GenreService {

    List<GenreResponseDto> getAllGenre();

    Genre findGenreById(Long id);

    void createGenre(GenreResponseDto genreResponseDto);

    void deleteById(Long id);
}
