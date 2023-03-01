package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.FolderMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderMovieRepository extends JpaRepository<FolderMovie, Long> {
}
