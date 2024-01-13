package com.simpleQuiz.simple.quiz.project.quiz.DTO.request;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Answers;
import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Questions;
import lombok.Data;

@Data
public class TakeQuizRequest {
    private long studentId;
    private JS1Answers answer;
    private long quizResultId;
    private JS1Questions question;

}
