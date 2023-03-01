package com.kata.cinema.base.webapp.controllers.resource;

import com.kata.cinema.base.service.recource.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Controller
public class ResourcesController {

    private final ImageService imageService;

    @Autowired
    public ResourcesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/uploads/**")
    public ResponseEntity<byte[]> getImage(HttpServletRequest request) throws IOException {
        String requestPath = URLDecoder.decode(request.getRequestURI(), StandardCharsets.UTF_8);
        return imageService.pngToResponse("src/main/resources" + requestPath);
    }
}