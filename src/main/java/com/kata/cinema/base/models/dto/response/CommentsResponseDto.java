package com.kata.cinema.base.models.dto.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentsResponseDto {

    @NotBlank
    private String text;

    private LocalDateTime date;
}
