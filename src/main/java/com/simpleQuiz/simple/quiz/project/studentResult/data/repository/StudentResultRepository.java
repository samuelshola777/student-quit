package com.simpleQuiz.simple.quiz.project.studentResult.data.repository;

import com.simpleQuiz.simple.quiz.project.student.data.model.StudentClass;
import com.simpleQuiz.simple.quiz.project.studentResult.data.model.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentResultRepository extends JpaRepository<StudentResult, Long> {

    boolean existsByStudent_EmailAndStudentClass(String email, StudentClass studentClass);
}
