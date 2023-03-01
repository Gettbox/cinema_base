package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.mappers.GenreMapper;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entity.Genre;
import com.kata.cinema.base.repositories.GenreRepository;
import com.kata.cinema.base.service.dto.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private final GenreMapper genreMapper;

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreMapper genreMapper, GenreRepository genreRepository) {
        this.genreMapper = genreMapper;
        this.genreRepository = genreRepository;
    }

    public List<GenreResponseDto> getAllGenre() {
        return genreMapper.modelsToDTO(genreRepository.findAll());

    }

    public Genre findGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void createGenre(GenreResponseDto genreResponseDto) {
        genreRepository.save(genreMapper.toEntity(genreResponseDto));
    }

    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
