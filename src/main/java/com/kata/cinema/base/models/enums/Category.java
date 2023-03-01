package com.kata.cinema.base.models.enums;

import lombok.Getter;

public enum Category {
    WAITING_MOVIES("Буду смотреть" ), FAVORITE_MOVIES("Любимые фильмы" ), VIEWED_MOVIES("Просмотренные" ), CUSTOM("Новый список" );

    @Getter
    private final String translation;

    Category(String translation) {
        this.translation = translation;
    }
}
