package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entity.Genre;

import java.util.List;

public interface GenreService {
    void save(Genre genre);

    List<Genre> getAll();
}
