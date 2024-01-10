package com.simpleQuiz.simple.quiz.project.student.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Student student;

}
