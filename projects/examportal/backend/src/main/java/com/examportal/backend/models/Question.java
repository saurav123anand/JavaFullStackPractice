package com.examportal.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;
    @Column(length=5000)
    private String content;
    private String image;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(quesId, question.quesId) && Objects.equals(content, question.content) && Objects.equals(image, question.image) && Objects.equals(option1, question.option1) && Objects.equals(option2, question.option2) && Objects.equals(option3, question.option3) && Objects.equals(option4, question.option4) && Objects.equals(answer, question.answer) && Objects.equals(quiz, question.quiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quesId);
    }
}
