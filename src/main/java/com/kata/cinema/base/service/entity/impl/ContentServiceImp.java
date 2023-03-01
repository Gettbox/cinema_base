package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.models.entity.Content;
import com.kata.cinema.base.repositories.ContentRepository;
import com.kata.cinema.base.repositories.MovieRepository;
import com.kata.cinema.base.service.entity.ContentService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ContentServiceImp implements ContentService {

    private final ContentRepository contentRepository;
    private final MovieRepository movieRepository;

    public ContentServiceImp(ContentRepository contentRepository, MovieRepository movieRepository) {
        this.contentRepository = contentRepository;
        this.movieRepository = movieRepository;
    }


    @Override
    public void save(Content content) {
        contentRepository.save(content);
    }

    @Override
    public void saveFile(Long id, File file) {
        Content content = new Content();
        content.setMovie(movieRepository.getById(id));
        content.setContentUrl(file.toString());
        contentRepository.save(content);
    }
}
