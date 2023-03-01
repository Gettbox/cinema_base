package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.models.entity.Collection;
import com.kata.cinema.base.repositories.CollectionRepository;
import org.springframework.stereotype.Service;
import com.kata.cinema.base.service.entity.CollectionService;


@Service
public class CollectionServiceImp implements CollectionService {
    private final CollectionRepository collectionRepository;

    public CollectionServiceImp(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Override
    public void save(Collection collection) {
        collectionRepository.save(collection);
    }
}
