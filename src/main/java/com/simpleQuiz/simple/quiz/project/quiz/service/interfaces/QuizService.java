package com.simpleQuiz.simple.quiz.project.quiz.service.interfaces;

import com.simpleQuiz.simple.quiz.project.quiz.DTO.request.TakeQuizRequest;
import com.simpleQuiz.simple.quiz.project.quiz.DTO.response.TakeQuizResponse;
import com.simpleQuiz.simple.quiz.project.quiz.data.model.QuizResult;
import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Questions;

public interface QuizService {
   JS1Questions setQuizQuestion(long studentId);
    QuizResult findById(long id);

    TakeQuizResponse studentAnswerQuestion(TakeQuizRequest takeQuizRequest);

    void deleteStudentQuizResult(QuizResult foundQuizResult);

    boolean deleteQuiz(long id);

    int deleteAllQuestionsAskedByQuizId(long id);
}
