package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Modifying
    @Query("delete from Question where news.id = ?1")
    void deleteQuestion(Long news_id);
}
