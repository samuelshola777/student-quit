package com.simpleQuiz.simple.quiz.project.student.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDateTime registeredTime;
    @Enumerated(EnumType.STRING)
    private StudentClass studentClass;

}
