package com.examportal.backend.service.impl;

import com.examportal.backend.exceptions.CategoryNotFoundException;
import com.examportal.backend.exceptions.QuizNotFoundException;
import com.examportal.backend.models.Category;
import com.examportal.backend.models.Quiz;
import com.examportal.backend.repository.QuizRepository;
import com.examportal.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) throws QuizNotFoundException {
        Optional<Quiz> quiz= quizRepository.findById(quizId);
        if(!quiz.isPresent()){
            throw new QuizNotFoundException("Category not found for id "+quizId);
        }
        return quiz.get();
    }

    @Override
    public void deleteQuiz(Long quizId) {

    }
}
