package com.simpleQuiz.simple.quiz.project.quiz.service.interfaces;
import com.simpleQuiz.simple.quiz.project.quiz.DTO.request.TakeQuizRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuizServiceTest {
@Autowired
private  QuizService quizService;
    private TakeQuizRequest takeQuizRequest;
    @BeforeEach
    void setUp() {
        takeQuizRequest.setQuizResultId(1);
        takeQuizRequest.setAnswer("");
        takeQuizRequest.setStudentId(2);

    }

    @Test
    void testThatStudentCanTakeQuiz(){
   String question =  quizService.setQuizQuestion(takeQuizRequest.getStudentId());


    }
}