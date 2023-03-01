package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.service.dto.CommentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserNewsRestController {

    private final CommentsService commentsService;

    public UserNewsRestController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/api/user/news/{id}/comments?userId=?")
    public void createComment(@PathVariable Long id, @RequestBody CommentsResponseDto commentsResponseDto) {
        commentsService.createComment(commentsResponseDto);
    }
}
