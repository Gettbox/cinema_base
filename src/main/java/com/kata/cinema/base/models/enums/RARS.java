package com.kata.cinema.base.models.enums;

import lombok.Getter;

import java.util.Random;

public enum RARS {
    ZERO_PLUS("0+"),
    SIX_PLUS("6+"),
    TWELVE_PLUS("12+"),
    SIXTEEN_PLUS("16+"),
    EIGHTEEN_PLUS("18+");

    @Getter
    private final String translation;

    RARS(String translation) {
        this.translation = translation;
    }

    public static RARS generateRandomRARS() {
        return RARS.values()[new Random().nextInt(RARS.values().length)];

    }

    @Override
    public String toString() {
        return " + translation + ";
    }
}
