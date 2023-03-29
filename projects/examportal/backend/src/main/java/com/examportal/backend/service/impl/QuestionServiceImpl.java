package com.examportal.backend.service.impl;

import com.examportal.backend.exceptions.QuestionNotFoundException;
import com.examportal.backend.exceptions.QuizNotFoundException;
import com.examportal.backend.models.Question;
import com.examportal.backend.models.Quiz;
import com.examportal.backend.repository.QuestionRepository;
import com.examportal.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long quesId) throws QuestionNotFoundException {
        Optional<Question> question= questionRepository.findById(quesId);
        if(!question.isPresent()){
            throw new QuestionNotFoundException("Category not found for id "+quesId);
        }
        return question.get();
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        questionRepository.deleteById(quesId);
    }
}
