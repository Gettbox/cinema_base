package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.request.ProductionStudioRequestDto;

public interface ProductionStudioService {

    void saveProductionStudio(ProductionStudioRequestDto productionStudioRequestDto);

    void deleteProductionStudio(Long id);

    void updateProductionStudio(Long id, ProductionStudioRequestDto productionStudioRequestDto);
}