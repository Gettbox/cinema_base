package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Modifying
    @Query("delete from Answer where question.id = ?1")
    void deleteAnswer(Long quest_id);
}
