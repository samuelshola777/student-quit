package com.simpleQuiz.simple.quiz.project.student.service.implementation;

import com.simpleQuiz.simple.quiz.project.student.DTO.request.StudentRequest;
import com.simpleQuiz.simple.quiz.project.student.DTO.response.StudentResponse;
import com.simpleQuiz.simple.quiz.project.student.data.model.Student;
import com.simpleQuiz.simple.quiz.project.student.data.model.StudentClass;
import com.simpleQuiz.simple.quiz.project.student.data.repository.StudentRepository;
import com.simpleQuiz.simple.quiz.project.student.service.interfaces.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class StudentServiceIMPL implements StudentService {
    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders httpHeaders = new HttpHeaders();

    @Value("${QuiID}")
    private String quok;

    @Value("${QuiKey}")
    private String quokey;

    @Override
    public StudentResponse registerNewStudent(StudentRequest studentRequest4) {
        if (studentRepository.existsByEmail(studentRequest4.getEmail()))
            throw new RuntimeException("Student already exists");
        Student student = new Student();
        student.setEmail(studentRequest4.getEmail());
        student.setStudentClass(StudentClass.JS1);
        student.setRegisteredTime(LocalDateTime.now());
        student.setFirstName(studentRequest4.getFirstName());
        student.setLastName(studentRequest4.getLastName());
        student.setPassword(studentRequest4.getPassword());
        Student savedStudent = studentRepository.save(student);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setEmail(savedStudent.getEmail());
        studentResponse.setFirstName(savedStudent.getFirstName());
        studentResponse.setLastName(savedStudent.getLastName());
        studentResponse.setStudentClass(savedStudent.getStudentClass());
        return studentResponse;
    }

    @Override
    public Student findStudentByStudentId(long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Could not find student with the id  " + studentId));
    }

}