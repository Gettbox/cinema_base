package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.models.dto.request.ProductionStudioRequestDto;
import com.kata.cinema.base.service.dto.ProductionStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/studios")
public class AdminProductionStudioRestController {

    private final ProductionStudioService productionStudioService;

    @Autowired
    public AdminProductionStudioRestController(ProductionStudioService productionStudioService) {
        this.productionStudioService = productionStudioService;
    }

    @PostMapping
    public ResponseEntity<ProductionStudioRequestDto> saveProductionStudio(@RequestBody ProductionStudioRequestDto productionStudioRequestDto) {
        productionStudioService.saveProductionStudio(productionStudioRequestDto);
        return new ResponseEntity<>(productionStudioRequestDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProductionStudio(@PathVariable("id") Long id) {
        productionStudioService.deleteProductionStudio(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductionStudioRequestDto> updateProductionStudio(@PathVariable("id") Long id, @RequestBody ProductionStudioRequestDto productionStudioRequestDto) {
        productionStudioService.updateProductionStudio(id, productionStudioRequestDto);
        return new ResponseEntity<>(productionStudioRequestDto, HttpStatus.OK);
    }
}
