package com.simpleQuiz.simple.quiz.project.student.controller;

import com.simpleQuiz.simple.quiz.project.generalAppConfig.ControllerResponseHandler;
import com.simpleQuiz.simple.quiz.project.student.DTO.request.StudentRequest;
import com.simpleQuiz.simple.quiz.project.student.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("register")
    public ResponseEntity<?> studentRegister(@RequestBody StudentRequest studentRequest) {
        try {
            return ControllerResponseHandler.responseBuilder("registration completed ", HttpStatus.ACCEPTED, studentService.registerNewStudent(studentRequest));
        } catch (Exception e) {
            return ControllerResponseHandler.responseBuilder("an error occurred ", HttpStatus.FAILED_DEPENDENCY);
        }
    }

}
