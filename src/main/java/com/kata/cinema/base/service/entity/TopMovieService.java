package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entity.TopMovie;

import java.io.IOException;
import java.sql.SQLException;

public interface TopMovieService {
    void save(TopMovie topMovie);
    void deleteAll();
    void set(int scoreAmount, int limit) throws SQLException, IOException;
}
