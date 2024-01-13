package com.simpleQuiz.simple.quiz.project.quiz.service.implementation;

import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Questions;
import com.simpleQuiz.simple.quiz.project.quiz.data.model.QuizResult;
import com.simpleQuiz.simple.quiz.project.quiz.data.repository.QuizResultRepository;
import com.simpleQuiz.simple.quiz.project.quiz.service.interfaces.QuizService;
import com.simpleQuiz.simple.quiz.project.student.service.interfaces.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class QuizServiceIMPL implements QuizService {
    private final StudentService studentService;
    private final QuizResultRepository quizResultRepository;
    private SecureRandom secureRandom = new SecureRandom();

    @Override
    public String setQuizQuestion(long studentId) {
        QuizResult foundQuizResult = quizResultRepository.findByStudentIdAndSubmittedFalse(studentId);
        if (foundQuizResult == null) foundQuizResult = new QuizResult();
        if (foundQuizResult.getListOfQuestionsAsked().size() ==  10) throw new RuntimeException("the 10 questions has been asked");
        JS1Questions question = generateRandomQuestion(foundQuizResult);
        foundQuizResult.setQuizTime(LocalDateTime.now());
        foundQuizResult.getListOfQuestionsAsked().add(question);
        foundQuizResult.setStudent(studentService.findStudentByStudentId(studentId));
        foundQuizResult.setSubmitted(false);
        quizResultRepository.save(foundQuizResult);
        return question.getQuestion();
    }

    @Override
    public QuizResult findById(long id) {
       return quizResultRepository.findById(id).orElseThrow(()-> new RuntimeException("couldn't find quiz result by id"));
    }

    private JS1Questions generateRandomQuestion(QuizResult quizResult){
        List<JS1Questions> listOfJS1Questions = Arrays.asList(JS1Questions.values());
        QuizResult foundQuizResult = null;
        JS1Questions question = listOfJS1Questions.get(secureRandom.nextInt(listOfJS1Questions.size()));
        try{
            foundQuizResult = findById(quizResult.getId());
        }catch (Exception e){
            log.info("could not find by id " + quizResult.getId() );
        }
       if (foundQuizResult != null){
           if (foundQuizResult.getListOfQuestionsAsked().contains(question)) {
            question = generateRandomQuestion(foundQuizResult);
           }
       }
return question;
    }

}
