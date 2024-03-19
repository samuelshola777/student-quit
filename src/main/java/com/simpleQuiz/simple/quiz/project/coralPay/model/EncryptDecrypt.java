//package com.simpleQuiz.simple.quiz.project.coralPay.model;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//public class EncryptDecrypt {
//    public static String encrypt(String value) {
//        try {
//            IvParameterSpec iv = new IvParameterSpec(Constants.Encryption.INIT_VECTOR.getBytes(StandardCharsets.UTF_8));
//            SecretKeySpec skeySpec = new
//                    SecretKeySpec("PRIVATE_KEY_FOR_ENCRYPTION_OR_DECRYPTION"
//                    .getBytes(StandardCharsets.UTF_8), "AES");
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//
//            byte[] encrypted = cipher.doFinal(value.getBytes());
//            byte[] original = Base64.getEncoder().encode(encrypted);
//            return new String(original);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    public static String decrypt(String encrypted) {
//        try {
//            IvParameterSpec iv = new IvParameterSpec(Constants.Encryption.INIT_VECTOR
//                    .getBytes(StandardCharsets.UTF_8));
//            SecretKeySpec skeySpec = new SecretKeySpec("PRIVATE_KEY_FOR_ENCRYPTION_OR_DECRYPTION".
//                    getBytes(StandardCharsets.UTF_8), "AES");
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
//            return new String(original);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
//}
