package com.simpleQuiz.simple.quiz.project.quiz.data.model;
import lombok.Getter;


@Getter
public enum JS1Questions {

        QUESTION1 ("What is a default and conversion constructor?"),
        QUESTION2("What are the advantages and disadvantages of multiple inheritance? "),
        QUESTION3("What is garbage collection, and how does it work?"),
        QUESTION4("What is a deadlock, and how can you prevent it?"),
        QUESTION5("What is the difference between a compiler and an interpreter?"),
        QUESTION6("What is the difference between overriding and overloading? "),
        QUESTION7("What is a character stream?"),
        QUESTION8("Can you explain the software development life cycle?"),
        QUESTION9("Can you explain the difference between statically typed and dynamically typed programming languages?"),
        QUESTION10("What is normalization and why is it important in database design?");

    private String question;
    JS1Questions(String question) {
        this.question = question;
    }
}
