package com.kata.cinema.base.models.dto.request;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class QuestionRequestDto {

    private Integer position;

    private String question;

    private List<AnswerRequestDto> answers;

    private List<ResultRequestDto> results;
}
