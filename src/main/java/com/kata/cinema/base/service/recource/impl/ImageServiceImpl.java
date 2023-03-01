package com.kata.cinema.base.service.recource.impl;

import com.kata.cinema.base.service.recource.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.RandomAccessFile;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public ResponseEntity<byte[]> pngToResponse(String path) throws IOException {
        RandomAccessFile file = new RandomAccessFile(path, "r");
        byte[] bytes = new byte[(int)file.length()];
        file.readFully(bytes);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }
}
