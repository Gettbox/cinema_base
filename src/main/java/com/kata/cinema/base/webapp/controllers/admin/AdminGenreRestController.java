package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entity.Genre;
import com.kata.cinema.base.service.dto.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminGenreRestController {

    private final GenreService genreService;

    @Autowired
    public AdminGenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/api/admin/genres")
    public List<GenreResponseDto> getAllGenre() {
        return genreService.getAllGenre();
    }

    @PostMapping("/api/admin/genres")
    public void createGenre(@RequestBody GenreResponseDto genreResponseDto) {
        genreService.createGenre(genreResponseDto);
    }

    @PutMapping("/api/admin/genres/{id}")
    public void updateGenre(@PathVariable long id,@RequestBody GenreResponseDto genreResponseDto) {
        Genre updateGenre = genreService.findGenreById(id);
        updateGenre.setName(genreResponseDto.getName());
        genreService.createGenre(genreResponseDto);
    }

    @DeleteMapping("/api/admin/genres/{id}")
    public void delete(@PathVariable("id") Long id) {
        genreService.deleteById(id);
    }
}
