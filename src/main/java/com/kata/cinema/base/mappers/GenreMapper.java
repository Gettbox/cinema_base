package com.kata.cinema.base.mappers;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreResponseDto toDTO (Genre genre);

    List<GenreResponseDto> modelsToDTO (List<Genre> genre);

    Genre toEntity (GenreResponseDto genreResponseDto);

}
