package com.examportal.backend.controller;

import com.examportal.backend.models.Quiz;
import com.examportal.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    //get Quiz
    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable Long quizId) throws Exception {
        return this.quizService.getQuiz(quizId);
    }

    // get all quizzes
    @GetMapping("/")
    public Set<Quiz> getQuizzes() {
        return this.quizService.getQuizzes();
    }

    //update quiz
    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz quiz) {
        return quizService.updateQuiz(quiz);
    }

    //delete quiz
    @DeleteMapping("/{quizId}")
    public String deleteQuiz(@PathVariable Long quizId) throws Exception {
        quizService.deleteQuiz(quizId);
        return "Quiz deleted for id " + quizId;
    }

}
