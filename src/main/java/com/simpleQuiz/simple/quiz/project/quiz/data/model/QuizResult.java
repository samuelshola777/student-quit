package com.simpleQuiz.simple.quiz.project.quiz.data.model;
import com.simpleQuiz.simple.quiz.project.student.data.model.Student;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "JS1Questions")
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Student student;
    private long numberOfCorrectAnswer;
    private long numberOfWrongAnswer;
    private LocalDateTime quizTime;
    @ElementCollection(targetClass = JS1Questions.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "quiz_wrong_question", joinColumns = @JoinColumn(name = "quiz_result_id"))
    @Enumerated(EnumType.STRING)
    private List<JS1Questions> listOfWrongQuestions = new ArrayList<>();
    private boolean submitted;

    @ElementCollection(targetClass = JS1Questions.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "quiz_wrong_question", joinColumns = @JoinColumn(name = "quiz_result_id"))
    @Enumerated(EnumType.STRING)
    private List<JS1Questions> listOfQuestionsAsked = new ArrayList<>();


}
