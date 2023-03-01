package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import com.kata.cinema.base.service.entity.MovieService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieServiceImp implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
