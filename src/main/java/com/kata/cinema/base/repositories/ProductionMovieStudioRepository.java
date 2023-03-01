package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.ProductionStudioMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionMovieStudioRepository extends JpaRepository<ProductionStudioMovie, Long> {

    @Query("select psm from ProductionStudioMovie psm left join fetch psm.performance")
    ProductionStudioMovie findProductionStudioMovieById(Long id);
}