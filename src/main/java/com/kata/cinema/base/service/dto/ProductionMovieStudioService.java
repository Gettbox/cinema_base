package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto;

public interface ProductionMovieStudioService {

    ProductionMovieStudioResponseDto getProductionMovieStudioResponseDto(Long id);
}