package com.examportal.backend.service;

import com.examportal.backend.exceptions.QuizNotFoundException;
import com.examportal.backend.models.Quiz;

import java.util.Set;

public interface QuizService {
    Quiz addQuiz(Quiz quiz);
    Quiz updateQuiz(Quiz quiz);
    Set<Quiz> getQuizzes();
    Quiz getQuiz(Long quizId) throws QuizNotFoundException;
    void deleteQuiz(Long quizId);
}
