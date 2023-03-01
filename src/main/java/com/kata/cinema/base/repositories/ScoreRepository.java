package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>  {

}