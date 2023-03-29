package com.examportal.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qid;
    private String title;
    private String description;
    private String maxMarks;
    private String numberOfQuestions;
    private boolean active = false;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Question> questions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return active == quiz.active && Objects.equals(qid, quiz.qid) && Objects.equals(title, quiz.title) && Objects.equals(description, quiz.description) && Objects.equals(maxMarks, quiz.maxMarks) && Objects.equals(numberOfQuestions, quiz.numberOfQuestions) && Objects.equals(category, quiz.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qid);
    }
}
