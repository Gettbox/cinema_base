package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.ProductionStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionStudioRepository extends JpaRepository<ProductionStudio, Long> {
}

