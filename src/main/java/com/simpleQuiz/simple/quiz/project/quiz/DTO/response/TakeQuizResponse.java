package com.simpleQuiz.simple.quiz.project.quiz.DTO.response;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Questions;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
    public class TakeQuizResponse {

    private String question;
    private String answer;
    private String studentEmail;
    private long numberOfCorrectAnswer;
    private long numberOfWrongAnswer;
    private List<JS1Questions> listOfQuestionsAsked = new ArrayList<>();
    private List<JS1Questions> listOfWrongQuestions = new ArrayList<>();
    private boolean submitted;
    private LocalDateTime quizTime;
    private boolean correctAnswer;
}
