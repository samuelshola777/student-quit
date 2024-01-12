package com.simpleQuiz.simple.quiz.project.quiz.DTO.request;

import lombok.Data;

@Data
public class TakeQuizRequest {
    private long studentId;
    private String answer;
    private long quizResultId;
    private String question;

}
