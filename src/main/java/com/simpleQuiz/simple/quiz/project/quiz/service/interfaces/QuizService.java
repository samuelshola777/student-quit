package com.simpleQuiz.simple.quiz.project.quiz.service.interfaces;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.QuizResult;

public interface QuizService {
    String setQuizQuestion(long studentId);
    QuizResult findById(long id);

}
