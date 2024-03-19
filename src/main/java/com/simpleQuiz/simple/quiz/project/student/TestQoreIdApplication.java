package com.simpleQuiz.simple.quiz.project.student;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;


public class TestQoreIdApplication {

    public static void main(String[] args) {
        callEndpoint();
    }

    public static void callEndpoint() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("accept", "application/json");
        String authToken = getToken();
        System.out.println(authToken);
        headers.set("authorization", String.format("Bearer %s", "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIzaVgtaEFrS3RmNUlsYWhRcElrNWwwbFBRVlNmVnpBdG9WVWQ4UXZ1OHJFIn0.eyJleHAiOjE3MDg5NTgyOTQsImlhdCI6MTcwODk1MTA5NCwianRpIjoiNTNlOTBiMTEtMzU2My00MjEzLTkxNGItMzVmODA2ZWE0MzBkIiwiaXNzIjoiaHR0cHM6Ly9hdXRoLnFvcmVpZC5jb20vYXV0aC9yZWFsbXMvcW9yZWlkIiwiYXVkIjpbInFvcmVpZGFwaSIsImFjY291bnQiXSwic3ViIjoiMThiNTdiNWYtNmJkOS00MjdjLTk5ZjAtNDM2Mzg4NDRhMGM3IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiNUJZVzQwUUdKWEI4OVFGOFA3VzYiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLXFvcmVpZCJdfSwicmVzb3VyY2VfYWNjZXNzIjp7InFvcmVpZGFwaSI6eyJyb2xlcyI6WyJ2ZXJpZnlfdmlydHVhbF9uaW5fc3ViIiwidmVyaWZ5X25pbl9zdWIiXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoicHJvZmlsZSBlbWFpbCIsImVudmlyb25tZW50Ijoic2FuZGJveCIsImNsaWVudEhvc3QiOiIxOTIuMTY4LjEzMi4yMDEiLCJjbGllbnRJZCI6IjVCWVc0MFFHSlhCODlRRjhQN1c2Iiwib3JnYW5pc2F0aW9uSWQiOjEzNjIzMSwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtNWJ5dzQwcWdqeGI4OXFmOHA3dzYiLCJhcHBsaWNhdGlvbklkIjoxOTY1NCwiY2xpZW50QWRkcmVzcyI6IjE5Mi4xNjguMTMyLjIwMSJ9.cwfSBe4N72GmBI8zIfPyvPlmQxD8YvJp7Aij2ltyVQQ5YhXRh8i-VVf9W8yZjKs0x5i2jsqfv8WEwoc_70dYalqTIManFQN72rrQdRTdA2-UPoDclJF1kMGsa7rhoyzyxk1pW9ycHDBhWLZNB0ENhrt70u4OV_ut-BZ6iy6h6aK3VUgl22Bsre-HQkX6CC2Rnfk0JR6jYeC4ZxcGAv_dF2OJFpID8sdu87LMQtGO2OjVLeo3bbW4biF33lQamw6g0OvoEIt4gjk4bD6WdF-msxOjVgE7LIx2yGaQgF6UHUt2yC1PcDnhMnbOTutN0OqYR0TZz-ujPz-OfrI4o9uz7A"));

        String requestBody = "{\"firstname\":\"Bunch\",\"lastname\":\"Dillon\"}";
        String userNIN = "63184876213";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                String.format("https://api.qoreid.com/v1/ng/identities/nin/%s", userNIN),
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String responseBody = responseEntity.getBody();
            processResponse(responseBody);
        } else {
            System.out.println(responseEntity.getStatusCode());
            System.out.println(responseEntity.getBody());
        }
    }

    public static void processResponse(String responseBody) {
        // Parse the response JSON string into a JSONObject
        JSONObject responseJson = new JSONObject(responseBody);

        // Get specific parts of the response using JSONObject methods
        int id = responseJson.getInt("id");
        JSONObject applicant = responseJson.getJSONObject("applicant");
        String firstname = applicant.getString("firstname");
        String lastname = applicant.getString("lastname");

        JSONObject summary = responseJson.getJSONObject("summary");
        JSONObject ninCheck = summary.getJSONObject("nin_check");
        String status = ninCheck.getString("status");

        JSONObject nin = responseJson.getJSONObject("nin");
        String ninNumber = nin.getString("nin");
        String gender = nin.getString("gender");

        System.out.println("ID: " + id);
        System.out.println("Applicant First Name: " + firstname);
        System.out.println("Applicant Last Name: " + lastname);
        System.out.println("NIN Check Status: " + status);
        System.out.println("NIN Number: " + ninNumber);
        System.out.println("Gender: " + gender);
    }

    public static String getToken() {
        String clientId = "5BYW40QGJXB89QF8P7W6";
        String secret = "bce29f3b72714a8eb59e28e7e7cf87ce";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("accept", "application/json");

        String requestBody = String.format("{\"clientId\":\"%s\",\"secret\":\"%s\"}", clientId, secret);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send POST request
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://api.qoreid.com/token",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Process response
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String responseBody = responseEntity.getBody();

            // Parse response JSON
            JSONObject responseJson = new JSONObject(responseBody);

            // Get accessToken from response JSON
            return responseJson.getString("accessToken");
        } else {
            return "";
        }
    }


}