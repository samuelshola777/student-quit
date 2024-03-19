package com.simpleQuiz.simple.quiz.project.coralPay;

import lombok.Data;

@Data
public class PosRequest {
    private String terminalId;
    private double amount;
    private String tnx;
    private String merchantId;
}
