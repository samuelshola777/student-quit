package com.simpleQuiz.simple.quiz.project.generalAppConfig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ControllerResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject){
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);
        response.put("StatusCode", httpStatus.value());
        response.put("timeStamp", LocalDateTime.now());
        return new ResponseEntity<>(response, httpStatus);
    }
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus){
        Map<String, Object> response = new HashMap<String, Object>();
        int[] emptyArray = new int[0];
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        response.put("data", emptyArray);
        response.put("StatusCode", httpStatus.value());
        response.put("timeStamp", LocalDateTime.now());
        return new ResponseEntity<>(response, httpStatus);
    }

}
