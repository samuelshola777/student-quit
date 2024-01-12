package com.simpleQuiz.simple.quiz.project.quiz.data.repository;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {
    QuizResult findByStudentIdAndSubmittedFalse(long studentId);
}
