package com.simpleQuiz.simple.quiz.project.student.service.interfaces;

import com.simpleQuiz.simple.quiz.project.student.DTO.request.StudentRequest;
import com.simpleQuiz.simple.quiz.project.student.DTO.response.StudentResponse;

public interface StudentService {


    StudentResponse registerNewStudent(StudentRequest studentRequest4);
}
