package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.service.dto.CommentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NewsRestController {

    private final CommentsService commentsService;

    public NewsRestController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/api/news/{id}/comments")
    public List<CommentsResponseDto> getCommentsByDate(@PathVariable("id") Long id) {
        return commentsService.getCommentsByDate(id);
    }
}
