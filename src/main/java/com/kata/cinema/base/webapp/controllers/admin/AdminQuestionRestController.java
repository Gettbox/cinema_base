package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.models.dto.request.QuestionRequestDto;
import com.kata.cinema.base.service.dto.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/news")
public class AdminQuestionRestController {

    private final QuestionService questionService;

    @Autowired
    public AdminQuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/{news_id}/questions")
    public ResponseEntity<List<QuestionRequestDto>> postQuestion(@PathVariable("news_id") Long id,
                                                                 @RequestBody List<QuestionRequestDto> list) {
        questionService.createQuestion(id, list);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @DeleteMapping("/{news_id}/questions/{quest_id}")
    public ResponseEntity<Long> deleteQuestion(@PathVariable("news_id") Long news_id,
                                               @PathVariable("quest_id") Long quest_id) {
        questionService.deleteQuestion(news_id, quest_id);
        return new ResponseEntity<>(quest_id, HttpStatus.NO_CONTENT);
    }
}
