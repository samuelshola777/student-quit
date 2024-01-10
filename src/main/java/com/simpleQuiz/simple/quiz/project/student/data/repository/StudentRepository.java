package com.simpleQuiz.simple.quiz.project.student.data.repository;

import com.simpleQuiz.simple.quiz.project.student.data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
