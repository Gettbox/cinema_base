package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.TopMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TopMovieRepository extends JpaRepository<TopMovie, Long> {

    @Modifying
    @Query("delete from TopMovie where movie.id >= 0")
    void deleteAll();

    @Modifying
    @Transactional
    @Query(value = "call top_movie_set(?1,?2);", nativeQuery = true)
    void set(int scoreAmount, int limit);
}
