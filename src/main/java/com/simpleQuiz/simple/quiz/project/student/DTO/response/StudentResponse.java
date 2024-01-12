package com.simpleQuiz.simple.quiz.project.student.DTO.response;

import com.simpleQuiz.simple.quiz.project.student.data.model.StudentClass;
import lombok.Data;

@Data
public class StudentResponse {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private StudentClass studentClass;


}
