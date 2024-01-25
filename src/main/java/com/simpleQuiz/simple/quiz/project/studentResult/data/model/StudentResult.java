package com.simpleQuiz.simple.quiz.project.studentResult.data.model;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Questions;
import com.simpleQuiz.simple.quiz.project.student.data.model.Student;
import com.simpleQuiz.simple.quiz.project.student.data.model.StudentClass;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "student_result")
public class StudentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long numberOfCorrectAnswer;
    private long numberOfWrongAnswer;
    private LocalDateTime quizTime;
    @Enumerated(EnumType.STRING)
    private StudentClass studentClass;
    @Enumerated(EnumType.STRING)
    private StudentResultState studentResultState;
    @ElementCollection(targetClass = JS1Questions.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "result_wrong_question", joinColumns = @JoinColumn(name = "result_wrong_question_id"))
    @Enumerated(EnumType.STRING)
    private List<JS1Questions> listOfWrongQuestions = new ArrayList<>();

    @ManyToOne
    private Student student;

}
