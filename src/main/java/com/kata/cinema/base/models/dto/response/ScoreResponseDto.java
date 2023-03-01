
package com.kata.cinema.base.models.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoreResponseDto {

    private Long id;
    private Long userId;
    private Long movieId;
    private Integer score;
}