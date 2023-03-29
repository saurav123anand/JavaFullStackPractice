package com.examportal.backend.service;

import com.examportal.backend.exceptions.QuestionNotFoundException;
import com.examportal.backend.models.Question;
import com.examportal.backend.models.Quiz;

import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);
    Question updateQuestion(Question question);
    Set<Question> getQuestions();
    Question getQuestion(Long quesId) throws QuestionNotFoundException;
    Set<Question> getQuestionOfQuiz(Quiz quiz);
    void deleteQuestion(Long quesId);
}
