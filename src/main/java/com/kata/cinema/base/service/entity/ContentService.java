package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entity.Content;

import java.io.File;

public interface ContentService {
    void save(Content content);

    void saveFile(Long Id, File file);
}
