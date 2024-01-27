package com.simpleQuiz.simple.quiz.project.studentResult.service.interfaces;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResultServiceTest {

    @Autowired
    private ResultService resultService;


    @BeforeEach
    void setUp() {

    }
    @Test
    void markStudentQuiz(){
        assertDoesNotThrow(()->{
            resultService.markStudentQuiz(1,2);
        });
    }




}