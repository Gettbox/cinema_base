package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.impl.TopMovieDaoImpl;
import com.kata.cinema.base.models.entity.TopMovie;
import com.kata.cinema.base.repositories.TopMovieRepository;
import com.kata.cinema.base.service.entity.MovieService;
import com.kata.cinema.base.service.entity.TopMovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class TopMovieServiceImpl implements TopMovieService {

    private final TopMovieRepository topMovieRepository;
    private final MovieService movieService;
    private final TopMovieDaoImpl topMovieDao;

    public TopMovieServiceImpl(TopMovieRepository topMovieRepository, MovieService movieService, TopMovieDaoImpl topMovieDao) {
        this.topMovieRepository = topMovieRepository;
        this.movieService = movieService;
        this.topMovieDao = topMovieDao;
    }

    @Transactional
    public void save(TopMovie topMovie) {
        TopMovie top = new TopMovie();
        top.setRating(topMovie.getRating());
        top.setMovie(movieService.findById(topMovie.getMovie().getId()));
        topMovieRepository.save(top);
    }

    @Transactional
    public void deleteAll() {
        topMovieRepository.deleteAll();
    }

    @Transactional
    public void set(int scoreAmount, int limit) throws SQLException, IOException {
        topMovieDao.set(scoreAmount, limit);
    }
}
