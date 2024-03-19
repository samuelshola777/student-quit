//package com.simpleQuiz.simple.quiz.project.coralPay.service.impmlementation;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.simpleQuiz.simple.quiz.project.coralPay.model.EncryptDecrypt;
//import com.simpleQuiz.simple.quiz.project.coralPay.service.DTO.request.VerifyPosWebRequest;
//import com.simpleQuiz.simple.quiz.project.coralPay.service.DTO.response.VerifyPOSResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.bouncycastle.openpgp.*;
//import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.HttpOutputMessage;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.http.converter.HttpMessageNotWritableException;
//import org.springframework.stereotype.Service;
//
//import java.io.*;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//@Slf4j
//public class PosServiceIMPL {
//
//
//    /**
//     * response of API
//     *
//     * @param bytesToEncrypt byte array of response
//     * @return byte array of response
//     */
//    private byte[] encrypt(byte[] bytesToEncrypt) {
//        // do your encryption here
//        String apiJsonResponse = new String(bytesToEncrypt);
//
//        String encryptedString = EncryptDecrypt.encrypt(apiJsonResponse);
//        if (encryptedString != null) {
//            //sending encoded json response in data object as follows
//
//            //reference response: {"data":"thisisencryptedstringresponse"}
//
//            Map<String, String> hashMap = new HashMap<>();
//            hashMap.put("data", encryptedString);
//            JSONObject jsob = new JSONObject(hashMap);
//            return jsob.toString().getBytes();
//        } else
//            return bytesToEncrypt;
//    }
//}