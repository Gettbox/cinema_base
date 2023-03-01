package com.kata.cinema.base.models.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class AnswerRequestDto {

    private String answer;

    private Boolean isRight;
}
