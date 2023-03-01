
package com.kata.cinema.base.models.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoreRequestDto {

    private Long userId;
    private Long movieId;
    private Integer score;
}