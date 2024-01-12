package com.simpleQuiz.simple.quiz.project.quiz.service.implementation;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.JS1Questions;
import com.simpleQuiz.simple.quiz.project.quiz.data.model.QuizResult;
import com.simpleQuiz.simple.quiz.project.quiz.data.repository.QuizResultRepository;
import com.simpleQuiz.simple.quiz.project.quiz.service.interfaces.QuizService;
import com.simpleQuiz.simple.quiz.project.student.service.interfaces.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class QuizServiceIMPL implements QuizService {
    private final StudentService studentService;
    private final QuizResultRepository quizResultRepository;

    @Override
    public String setQuizQuestion(long studentId) {
        List<JS1Questions> listOfJS1Questions = Arrays.asList(JS1Questions.values());
        QuizResult foundQuizResult = quizResultRepository.findByStudentIdAndSubmittedFalse(studentId);
        return null;
    }
}
