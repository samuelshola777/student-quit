package com.simpleQuiz.simple.quiz.project.studentResult.service.implementation;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.QuizResult;
import com.simpleQuiz.simple.quiz.project.quiz.service.interfaces.QuizService;
import com.simpleQuiz.simple.quiz.project.student.data.model.Student;
import com.simpleQuiz.simple.quiz.project.student.service.interfaces.StudentService;
import com.simpleQuiz.simple.quiz.project.studentResult.data.model.StudentResult;
import com.simpleQuiz.simple.quiz.project.studentResult.data.model.StudentResultState;
import com.simpleQuiz.simple.quiz.project.studentResult.data.repository.StudentResultRepository;
import com.simpleQuiz.simple.quiz.project.studentResult.service.interfaces.ResultService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ResultServiceIMPL implements ResultService {
    private final QuizService quizService;
    private final StudentResultRepository studentResultRepository;



    @Override
    public StudentResult markStudentQuiz(long studentId, long quizId) {
        QuizResult foundQuizResult = quizService.findById(quizId);
        Student foundStudent = foundQuizResult.getStudent();
        if (foundQuizResult.getStudent().getId() != studentId) throw new RuntimeException("there's a mismatch between the student and the quiz");
        if (studentResultRepository.existsByStudent_EmailAndStudentClass(foundStudent.getEmail(), foundStudent.getStudentClass()))
            throw new RuntimeException("student can't have more than one of "+foundStudent.getStudentClass()+" quiz result");
        StudentResult studentResult = new StudentResult();
    studentResult.setStudent(foundStudent);
    studentResult.setStudentClass(foundStudent.getStudentClass());
    studentResult.setQuizTime(LocalDateTime.now());
    studentResult.setNumberOfCorrectAnswer(foundQuizResult.getNumberOfCorrectAnswer());
    studentResult.setNumberOfWrongAnswer(foundQuizResult.getNumberOfWrongAnswer());
    studentResult.getListOfWrongQuestions().addAll(foundQuizResult.getListOfWrongQuestions());
    if (foundQuizResult.getNumberOfCorrectAnswer() >= 5 ){
        studentResult.setStudentResultState(StudentResultState.PASS);
    }
        studentResult.setStudentResultState(StudentResultState.FAIL);
        StudentResult savedStudentResult =  studentResultRepository.save(studentResult);
        quizService.deleteStudentQuizResult(foundQuizResult);
        return savedStudentResult;
    }
}
