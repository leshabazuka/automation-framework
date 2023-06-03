package org.Tsyulia.util;

import java.util.Random;

public class StringUtils {
    public static final String HIGH_AND_SMALL_LETTERS_AND_DIGITS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String HIGH_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String SMALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String DIGITS = "0123456789";
    public static Random random = new Random();

    public static String generateRandomString(int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<length; i++){
            stringBuilder.append(HIGH_AND_SMALL_LETTERS_AND_DIGITS.charAt(random.nextInt(HIGH_AND_SMALL_LETTERS_AND_DIGITS.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomStringHighLetters(int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<length; i++){
            stringBuilder.append(HIGH_LETTERS.charAt(random.nextInt(HIGH_LETTERS.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomStringSmallLetters(int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<length; i++){
            stringBuilder.append(SMALL_LETTERS.charAt(random.nextInt(SMALL_LETTERS.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomStringDigits(int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<length; i++){
            stringBuilder.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomEmailAddress(){
        return generateRandomString(random.nextInt(10)+5)+"@gmail.com";
    }

    public static String generateRandomNameAndSurname(){
        return generateRandomStringHighLetters(1)+generateRandomStringSmallLetters(random.nextInt(5)+3)+
                " "+generateRandomStringHighLetters(1)+generateRandomStringSmallLetters(random.nextInt(8)+3);
    }

    public static String generateRandomPhone() {
        return "+48" + generateRandomStringDigits(9);
    }

    public static String generateRandomAmountOfPeople() {
        return String.valueOf(random.nextInt(20));
    }
}
