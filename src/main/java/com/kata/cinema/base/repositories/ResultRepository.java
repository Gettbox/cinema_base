package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    @Modifying
    @Query("delete from Result where question.id = ?1")
    void deleteResult(Long quest_id);
}
