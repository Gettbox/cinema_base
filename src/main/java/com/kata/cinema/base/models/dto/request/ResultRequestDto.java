package com.kata.cinema.base.models.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class ResultRequestDto {

    private Integer countRightAnswer;

    private String result;
}
