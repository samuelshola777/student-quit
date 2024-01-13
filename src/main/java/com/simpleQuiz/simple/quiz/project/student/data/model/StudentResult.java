package com.simpleQuiz.simple.quiz.project.student.data.model;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Questions;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "student_result")
public class StudentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ElementCollection(targetClass = JS1Questions.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "quiz_wrong_question", joinColumns = @JoinColumn(name = "quiz_result_id"))
//    @Enumerated(EnumType.STRING)
//    private List<JS1Questions> listOfWrongQuestions = new ArrayList<>();

    @ManyToOne
    private Student student;

}
