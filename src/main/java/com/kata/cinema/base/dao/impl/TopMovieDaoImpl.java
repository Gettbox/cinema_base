package com.kata.cinema.base.dao.impl;

import com.kata.cinema.base.dao.TopMovieDao;
import com.kata.cinema.base.repositories.TopMovieRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

@Repository
public class TopMovieDaoImpl implements TopMovieDao {

    private final JdbcTemplate jdbcTemplate;
    private final TopMovieRepository topMovieRepository;

    public TopMovieDaoImpl(JdbcTemplate jdbcTemplate, TopMovieRepository topMovieRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.topMovieRepository = topMovieRepository;
    }

    public void set(int scoreAmount, int limit) throws SQLException, IOException {

        jdbcTemplate.execute(Files.readString(Paths.get("src/main/resources/static/data/top_movies_set.sql")));
        topMovieRepository.set(scoreAmount, limit);
    }
}
