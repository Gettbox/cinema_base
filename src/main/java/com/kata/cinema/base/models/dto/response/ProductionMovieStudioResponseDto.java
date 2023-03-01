package com.kata.cinema.base.models.dto.response;

import com.kata.cinema.base.models.entity.StudioPerformance;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ProductionMovieStudioResponseDto {
    private Long id;
    private String name;
    private StudioPerformance studioPerformance;
}