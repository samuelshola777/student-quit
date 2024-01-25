package com.simpleQuiz.simple.quiz.project.quiz.service.implementation;

import com.simpleQuiz.simple.quiz.project.quiz.DTO.request.TakeQuizRequest;
import com.simpleQuiz.simple.quiz.project.quiz.DTO.response.TakeQuizResponse;
import com.simpleQuiz.simple.quiz.project.quiz.data.model.js1QuizZ.JS1Answers;
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
    public JS1Questions setQuizQuestion(long studentId) {
        QuizResult foundQuizResult = quizResultRepository.findByStudentIdAndSubmittedFalse(studentId);
        if (foundQuizResult == null) foundQuizResult = new QuizResult();
        if (foundQuizResult.getListOfQuestionsAsked().size() == 10)
            throw new RuntimeException("the 10 questions has been asked");
        JS1Questions question = generateRandomQuestion(foundQuizResult);
        foundQuizResult.setQuizTime(LocalDateTime.now());
        foundQuizResult.getListOfQuestionsAsked().add(question);
        foundQuizResult.setStudent(studentService.findStudentByStudentId(studentId));
        foundQuizResult.setSubmitted(false);
        quizResultRepository.save(foundQuizResult);
        return question;
    }

    @Override
    public QuizResult findById(long id) {
        return quizResultRepository.findById(id).orElseThrow(() -> new RuntimeException("couldn't find quiz result by id"));
    }

    @Override
    public TakeQuizResponse studentAnswerQuestion(TakeQuizRequest takeQuizRequest) {
        boolean correct = false;
        QuizResult foundQuizResult = quizResultRepository.findByStudentIdAndSubmittedFalse(takeQuizRequest.getStudentId());
        if (foundQuizResult == null)
            throw new RuntimeException("student with the id  >> " + takeQuizRequest.getStudentId() + "  <<< doesn't have quiz section");
        if (!foundQuizResult.getListOfQuestionsAsked().contains(takeQuizRequest.getQuestion()))
            throw new RuntimeException("the question  >> " + takeQuizRequest.getQuestion() + "  <<< is not recognized");
        List<JS1Questions> listOfQuestion = Arrays.asList(JS1Questions.values());
        int questionIndex = listOfQuestion.indexOf(takeQuizRequest.getQuestion());
        List<JS1Answers> listOfAnswer = Arrays.asList(JS1Answers.values());
        JS1Answers answer = listOfAnswer.get(questionIndex);
        if (answer != takeQuizRequest.getAnswer()) {
            log.info("i'm in the wrong method ****************************************************************************************************");
            foundQuizResult.setNumberOfWrongAnswer(foundQuizResult.getNumberOfWrongAnswer()+1);

            foundQuizResult.getListOfWrongQuestions().add(takeQuizRequest.getQuestion());
            log.info( foundQuizResult.getListOfWrongQuestions()+ " <<<<< i'm in the wrong method ****************************************************************************************************");

        } else {
            log.info("i'm in the right anwser method ****************************************************************************************************");
            foundQuizResult.setNumberOfCorrectAnswer(foundQuizResult.getNumberOfCorrectAnswer()+1);
            correct = true;
        }
        if (foundQuizResult.getNumberOfCorrectAnswer() + foundQuizResult.getNumberOfWrongAnswer() == 10) {
            foundQuizResult.setSubmitted(true);
            throw new RuntimeException("please submit your  quiz");
        }
        QuizResult savedQuizResult = quizResultRepository.save(foundQuizResult);
        TakeQuizResponse quizResponse = new TakeQuizResponse();
        quizResponse.setQuestion(takeQuizRequest.getQuestion().getQuestion());
        quizResponse.setQuizTime(LocalDateTime.now());
        quizResponse.setAnswer(answer.getAnswer());
        quizResponse.setSubmitted(savedQuizResult.isSubmitted());
        quizResponse.setNumberOfCorrectAnswer(savedQuizResult.getNumberOfCorrectAnswer());
        quizResponse.setNumberOfWrongAnswer(savedQuizResult.getNumberOfWrongAnswer());
        quizResponse.setStudentEmail(savedQuizResult.getStudent().getEmail());
        quizResponse.getListOfQuestionsAsked().addAll(savedQuizResult.getListOfQuestionsAsked());
        quizResponse.getListOfWrongQuestions().addAll(savedQuizResult.getListOfWrongQuestions());
        quizResponse.setCorrectAnswer(correct);
        return quizResponse;
    }

    @Override
    public void deleteStudentQuizResult(QuizResult foundQuizResult) {
       quizResultRepository.save(foundQuizResult);
    }

    @Override
    public boolean deleteQuiz(long id) {
        quizResultRepository.delete(findById(id));
        return quizResultRepository.existsById(id);
    }

    private JS1Questions generateRandomQuestion(QuizResult quizResult) {
        List<JS1Questions> listOfJS1Questions = Arrays.asList(JS1Questions.values());
        QuizResult foundQuizResult = null;
        JS1Questions question = listOfJS1Questions.get(secureRandom.nextInt(listOfJS1Questions.size()));
        try {
            foundQuizResult = findById(quizResult.getId());
        } catch (Exception e) {
            log.info("could not find by id " + quizResult.getId());
        }
        if (foundQuizResult != null) {
            if (foundQuizResult.getListOfQuestionsAsked().contains(question)) {
                question = generateRandomQuestion(foundQuizResult);
            }
        }
        return question;
    }

}
