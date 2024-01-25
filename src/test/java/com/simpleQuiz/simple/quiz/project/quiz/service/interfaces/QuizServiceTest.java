package com.simpleQuiz.simple.quiz.project.quiz.service.interfaces;
import com.simpleQuiz.simple.quiz.project.quiz.DTO.request.TakeQuizRequest;
import com.simpleQuiz.simple.quiz.project.quiz.DTO.response.TakeQuizResponse;
import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Answers;
import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Questions;
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
        takeQuizRequest = new TakeQuizRequest();



    }

    @Test
    void testThatStudentCanSetQuestionFOrStudent(){
   JS1Questions question =  quizService.setQuizQuestion(takeQuizRequest.getStudentId());
    assertEquals("tcttbyhvy", question.getQuestion());

    }
    @Test
    void testThatStudentCanAnswerQuizQuestion(){
        takeQuizRequest.setQuizResultId(1);
        takeQuizRequest.setStudentId(1);
        JS1Questions question =  quizService.setQuizQuestion(takeQuizRequest.getStudentId());
        takeQuizRequest.setQuestion(question);
        takeQuizRequest.setAnswer(JS1Answers.ANSWER6);
        TakeQuizResponse takeQuizResponse = quizService.studentAnswerQuestion(takeQuizRequest);
        assertTrue(takeQuizResponse.isCorrectAnswer());


    }

    @Test
    void deleteQuizById(){
    assertFalse(quizService.deleteQuiz(1));
    }


}