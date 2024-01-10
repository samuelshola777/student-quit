package com.simpleQuiz.simple.quiz.project.student.service.interfaces;

import com.simpleQuiz.simple.quiz.project.student.DTO.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class StudentServiceTest {
    private final StudentService studentService;

private StudentRequest studentRequest1;
private StudentRequest studentRequest2;
private StudentRequest studentRequest3;
private StudentRequest studentRequest4;


    @BeforeEach
    void setUp() {
        studentRequest1 = new StudentRequest();
        studentRequest1.setEmail("student1@gmail.com");
        studentRequest1.setPassword("password");
        studentRequest1.setFirstName("student1FirstName");
        studentRequest1.setLastName("student1LastName");

        studentRequest2 = new StudentRequest();
        studentRequest2.setEmail("student2@gmail.com");
        studentRequest2.setPassword("password");
        studentRequest2.setFirstName("student2FirstName");
        studentRequest2.setLastName("student2LastName");

        studentRequest3 = new StudentRequest();
        studentRequest3.setEmail("student3@gmail.com");
        studentRequest3.setPassword("password");
        studentRequest3.setFirstName("student3FirstName");
        studentRequest3.setLastName("student3LastName");

        studentRequest4 = new StudentRequest();
        studentRequest4.setEmail("student4@gmail.com");
        studentRequest4.setPassword("password");
        studentRequest4.setFirstName("student4FirstName");
        studentRequest4.setLastName("student4LastName");


    }
}