package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.models.dto.request.ProductionStudioRequestDto;
import com.kata.cinema.base.models.entity.ProductionStudio;
import com.kata.cinema.base.repositories.ProductionStudioRepository;
import com.kata.cinema.base.service.dto.ProductionStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductionStudioServiceImpl implements ProductionStudioService {

    private final ProductionStudioRepository productionStudioRepository;

    @Autowired
    public ProductionStudioServiceImpl(ProductionStudioRepository productionStudioRepository) {
        this.productionStudioRepository = productionStudioRepository;
    }

    @Transactional
    public void saveProductionStudio(ProductionStudioRequestDto productionStudioRequestDto) {
        ProductionStudio productionStudio = new ProductionStudio();
        productionStudio.setName(productionStudioRequestDto.getName());
        productionStudio.setDescription(productionStudioRequestDto.getDescription());
        productionStudio.setDateFoundation(productionStudioRequestDto.getDateFoundation());
        productionStudioRepository.save(productionStudio);
    }

    @Transactional
    public void deleteProductionStudio(Long id) {
        productionStudioRepository.deleteById(id);
    }

    @Transactional
    public void updateProductionStudio(Long id, ProductionStudioRequestDto productionStudioRequestDto) {
        ProductionStudio updateProductionStudio = productionStudioRepository.getById(id);
        updateProductionStudio.setName(productionStudioRequestDto.getName());
        updateProductionStudio.setDescription(productionStudioRequestDto.getDescription());
        updateProductionStudio.setDateFoundation(productionStudioRequestDto.getDateFoundation());
        productionStudioRepository.save(updateProductionStudio);
    }
}