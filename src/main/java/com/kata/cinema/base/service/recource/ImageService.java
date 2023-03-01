package com.kata.cinema.base.service.recource;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ImageService {

    ResponseEntity<byte[]> pngToResponse(String path) throws IOException;
}
