package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto;
import com.kata.cinema.base.models.entity.ProductionStudioMovie;
import com.kata.cinema.base.repositories.ProductionMovieStudioRepository;
import com.kata.cinema.base.service.dto.ProductionMovieStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class ProductionMovieStudioServiceImpl implements ProductionMovieStudioService {

    private final ProductionMovieStudioRepository productionMovieStudioRepository;

    @Autowired
    public ProductionMovieStudioServiceImpl(ProductionMovieStudioRepository productionMovieStudioRepository) {
        this.productionMovieStudioRepository = productionMovieStudioRepository;
    }

    @Transactional
    public ProductionMovieStudioResponseDto getProductionMovieStudioResponseDto(Long id) {
        ProductionMovieStudioResponseDto productionMovieStudioResponseDto = new ProductionMovieStudioResponseDto();
        if (productionMovieStudioRepository.existsById(id)) {
            ProductionStudioMovie productionStudioMovie = productionMovieStudioRepository.findProductionStudioMovieById(id);
            productionMovieStudioResponseDto.setId(id);
            productionMovieStudioResponseDto.setName(productionStudioMovie.getMovie().getName());
            productionMovieStudioResponseDto.setStudioPerformance(productionStudioMovie.getPerformance());
        } else {
            throw new NoSuchElementException();
        }
        return productionMovieStudioResponseDto;
    }
}