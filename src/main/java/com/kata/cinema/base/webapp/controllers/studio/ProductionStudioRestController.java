package com.kata.cinema.base.webapp.controllers.studio;

import com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto;
import com.kata.cinema.base.service.dto.ProductionMovieStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductionStudioRestController {

    private final ProductionMovieStudioService productionMovieStudioService;

    @Autowired
    public ProductionStudioRestController(ProductionMovieStudioService productionMovieStudioService) {
        this.productionMovieStudioService = productionMovieStudioService;
    }

    @GetMapping("/api/movies/{id}/studios")
    public ResponseEntity<ProductionMovieStudioResponseDto> getProductionMovieStudioResponseDto(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productionMovieStudioService.getProductionMovieStudioResponseDto(id), HttpStatus.OK);
    }
}
