package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entity.Movie;

import java.util.List;

public interface MovieService {
    void save(Movie movie);
    List<Movie> getAll();
    Movie findById(Long id);
}
