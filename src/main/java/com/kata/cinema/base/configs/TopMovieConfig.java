package com.kata.cinema.base.configs;

import com.kata.cinema.base.service.entity.TopMovieService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.sql.SQLException;

@Configuration
@EnableScheduling
@EnableAsync
@ComponentScan(value = "com.kata.cinema.base")
public class TopMovieConfig {

    private final TopMovieService topMovieService;

    public TopMovieConfig(TopMovieService topMovieService) {
        this.topMovieService = topMovieService;
    }

    @Async
    @Scheduled(cron = "0 0 0 * * SUN")
    public void set() throws IOException, SQLException {

        topMovieService.set(20, 50);
    }
}