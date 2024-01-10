package com.simpleQuiz.simple.quiz.project.student.data.repository;

import com.simpleQuiz.simple.quiz.project.student.data.model.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentResultRepository extends JpaRepository<StudentResult, Long> {
}
