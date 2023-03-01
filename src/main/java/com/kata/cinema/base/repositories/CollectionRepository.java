package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection,Long> {
}

