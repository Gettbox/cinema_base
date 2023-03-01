package com.kata.cinema.base.models.enums;

import lombok.Getter;
import java.util.Random;

@Getter
public enum MPAA {
    GENERAL_AUDIENCES("GENERAL AUDIENCES"),
    PARENTAL_GUIDANCE_SUGGESTED("PARENTAL GUIDANCE SUGGESTED"),
    PARENTS_STRONGLY_CAUTIONED("PARENTS STRONGLY CAUTIONED"),
    NO_ONE_SEVENTEEN_AND_UNDER_ADMITTED("NO ONE SEVENTEEN AND UNDER ADMITTED");

    @Getter
    private final String translation;

    MPAA(String translation) {
        this.translation = translation;
    }

    public static MPAA generateRandomMPAA() {
        return MPAA.values()[new Random().nextInt(MPAA.values().length)];
    }

    @Override
    public String toString() {
        return " + translation + ";
    }
}