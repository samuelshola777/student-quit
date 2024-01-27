package com.simpleQuiz.simple.quiz.project.quiz.controller;

import com.simpleQuiz.simple.quiz.project.generalAppConfig.ControllerResponseHandler;
import com.simpleQuiz.simple.quiz.project.quiz.DTO.request.TakeQuizRequest;
import com.simpleQuiz.simple.quiz.project.quiz.service.interfaces.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz/")
@RequiredArgsConstructor
public class quizController {
    private final QuizService service;


    @PostMapping("generateQuizQuestion")
    public ResponseEntity<?>  generateQuizQuestion(@RequestParam long studentId){
        try{
        return     ControllerResponseHandler.responseBuilder("question generated successfully", HttpStatus.CREATED,service.setQuizQuestion(studentId) );
        }catch (Exception e){
         return    ControllerResponseHandler.responseBuilder("question was not generated successfully", HttpStatus.BAD_REQUEST );
        }
    }

    @PostMapping("studentAnswerQuestion")
    public ResponseEntity<?> studentAnswerQuestion(@RequestBody TakeQuizRequest takeQuizRequest){
        try{
            return     ControllerResponseHandler.responseBuilder("question answered successfully", HttpStatus.CREATED,service.studentAnswerQuestion(takeQuizRequest) );
        }catch (Exception e){
            return    ControllerResponseHandler.responseBuilder("question was not answered successfully", HttpStatus.BAD_REQUEST );
        }
    }


}
