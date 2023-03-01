package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long>  {
}
