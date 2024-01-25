package com.simpleQuiz.simple.quiz.project.studentResult.service.interfaces;

import com.simpleQuiz.simple.quiz.project.studentResult.data.model.StudentResult;

public interface ResultService {

    StudentResult markStudentQuiz(long studentId, long quizId);
}
