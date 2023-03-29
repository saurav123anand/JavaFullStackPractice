package com.examportal.backend.controller;

import com.examportal.backend.models.Question;
import com.examportal.backend.models.Quiz;
import com.examportal.backend.service.QuestionService;
import com.examportal.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    //add question
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    //update question
    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    // get all question of any quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestions(@PathVariable Long quizId) throws Exception {
       Quiz quiz=quizService.getQuiz(quizId);
       Set<Question> questions=quiz.getQuestions();
        List<Question> list=new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return list;
    }
    // get single question
    @GetMapping("/{quesId}")
    public Question getQuestion(@PathVariable Long quesId) throws Exception {
        return questionService.getQuestion(quesId);
    }

    // delete question
    @DeleteMapping("/{quesId}")
    public String deleteQuestion(@PathVariable Long quesId) throws Exception {
       questionService.deleteQuestion(quesId);
       return "Question deleted for question id "+quesId;
    }

}
