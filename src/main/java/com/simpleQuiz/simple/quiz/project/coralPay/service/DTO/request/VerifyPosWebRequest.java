package com.simpleQuiz.simple.quiz.project.coralPay.service.DTO.request;

import com.simpleQuiz.simple.quiz.project.coralPay.PosRequest;
import com.simpleQuiz.simple.quiz.project.coralPay.UserInfo;
import lombok.Data;

@Data
public class VerifyPosWebRequest {
    private UserInfo userInfo;
    private PosRequest posRequest;
}
