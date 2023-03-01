package com.kata.cinema.base.models.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ProductionStudioRequestDto {
    private String name;
    private String description;
    private String dateFoundation;
}