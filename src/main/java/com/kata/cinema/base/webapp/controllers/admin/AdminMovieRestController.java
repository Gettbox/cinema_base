package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.service.entity.impl.ContentServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/moderator/movie")
public class AdminMovieRestController {
    private final ContentServiceImp contentService;

    public AdminMovieRestController(ContentServiceImp contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/{id}/uploadPreview")
    public ResponseEntity<?> uploadPreview(@PathVariable("id") Long movieId,
                                                @RequestParam("image") MultipartFile file) throws IOException {

        File convFile = new File("/uploads/movies/preview");
        file.transferTo(convFile);
        contentService.saveFile(movieId, convFile);
        return ResponseEntity.ok("upload");
    }
}