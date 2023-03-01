package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.models.dto.request.AnswerRequestDto;
import com.kata.cinema.base.models.dto.request.QuestionRequestDto;
import com.kata.cinema.base.models.dto.request.ResultRequestDto;
import com.kata.cinema.base.models.entity.Answer;
import com.kata.cinema.base.models.entity.News;
import com.kata.cinema.base.models.entity.Question;
import com.kata.cinema.base.models.entity.Result;
import com.kata.cinema.base.repositories.AnswerRepository;
import com.kata.cinema.base.repositories.NewsRepository;
import com.kata.cinema.base.repositories.QuestionRepository;
import com.kata.cinema.base.repositories.ResultRepository;
import com.kata.cinema.base.service.dto.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final NewsRepository newsRepository;
    private final AnswerRepository answerRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, NewsRepository newsRepository,
                               AnswerRepository answerRepository, ResultRepository resultRepository) {
        this.questionRepository = questionRepository;
        this.newsRepository = newsRepository;
        this.answerRepository = answerRepository;
        this.resultRepository = resultRepository;
    }

    @Transactional
    public void createQuestion(Long id, List<QuestionRequestDto> list) {
        News news = newsRepository.findById(id).orElseThrow(NoSuchElementException::new);

        for (QuestionRequestDto quest : list) {
            Question question = new Question();
            question.setNews(news);
            question.setPosition(quest.getPosition());
            question.setQuestion(quest.getQuestion());
            Question savedQuestion = questionRepository.save(question);

            for (AnswerRequestDto ans : quest.getAnswers()) {
                Answer answer = new Answer();
                answer.setQuestion(savedQuestion);
                answer.setAnswer(ans.getAnswer());
                answer.setIsRight(ans.getIsRight());
                answerRepository.save(answer);
            }

            for (ResultRequestDto res : quest.getResults()) {
                Result result = new Result();
                result.setQuestion(savedQuestion);
                result.setCountRightAnswer(res.getCountRightAnswer());
                result.setResult(res.getResult());
                resultRepository.save(result);
            }
        }
    }

    @Transactional
    public void deleteQuestion(Long news_id, Long quest_id) {
        answerRepository.deleteAnswer(quest_id);
        resultRepository.deleteResult(quest_id);
        questionRepository.deleteQuestion(news_id);
    }
}
