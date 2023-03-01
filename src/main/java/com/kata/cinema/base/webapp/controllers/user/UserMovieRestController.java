package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.response.ScoreResponseDto;
import com.kata.cinema.base.service.entity.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/movies/scopes")
public class UserMovieRestController {
    private final ScoreService scoreService;

    public UserMovieRestController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity<?> addScore(@RequestBody ScoreResponseDto scopeResponseDto) {
        scoreService.save(scopeResponseDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        scoreService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ScoreResponseDto> getProductRe(@PathVariable Long id) {
        return ResponseEntity.ok(scoreService.findById(id));
    }

}