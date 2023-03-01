package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.models.entity.FolderMovie;
import com.kata.cinema.base.repositories.FolderMovieRepository;
import com.kata.cinema.base.service.entity.FolderMovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FolderMovieServiceImpl implements FolderMovieService {

    private final FolderMovieRepository folderMovieRepository;

    public FolderMovieServiceImpl(FolderMovieRepository folderMovieRepository) {
        this.folderMovieRepository = folderMovieRepository;
    }

    @Transactional
    public void save(FolderMovie folderMovie) {
        folderMovieRepository.save(folderMovie);
    }
}
