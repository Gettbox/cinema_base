package com.kata.cinema.base.models.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ProductionStudioResponseDto {
    private Long id;
    private String name;
    private String description;
    private String dateFoundation;
}
