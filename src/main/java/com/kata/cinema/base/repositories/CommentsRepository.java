package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

    @Query("select c from Comments c LEFT JOIN FETCH c.news order by c.date")
    List<Comments> findListCommentsByNewsId(Long id);
}
