package com.kata.cinema.base.mappers;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entity.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-11T11:23:50+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreResponseDto toDTO(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreResponseDto genreResponseDto = new GenreResponseDto();

        genreResponseDto.setId( genre.getId() );
        genreResponseDto.setName( genre.getName() );

        return genreResponseDto;
    }

    @Override
    public List<GenreResponseDto> modelsToDTO(List<Genre> genre) {
        if ( genre == null ) {
            return null;
        }

        List<GenreResponseDto> list = new ArrayList<GenreResponseDto>( genre.size() );
        for ( Genre genre1 : genre ) {
            list.add( toDTO( genre1 ) );
        }

        return list;
    }

    @Override
    public Genre toEntity(GenreResponseDto genreResponseDto) {
        if ( genreResponseDto == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setId( genreResponseDto.getId() );
        genre.setName( genreResponseDto.getName() );

        return genre;
    }
}
