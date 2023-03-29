package com.examportal.backend.repository;

import com.examportal.backend.models.Question;
import com.examportal.backend.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
