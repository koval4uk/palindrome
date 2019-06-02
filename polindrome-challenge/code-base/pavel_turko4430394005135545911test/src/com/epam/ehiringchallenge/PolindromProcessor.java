package com.epam.ehiringchallenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class PolindromProcessor {

    private static long MAX_POLINDROME_SIZE = 0;

    public static List<String> getListMaxPolindromes(List<String> words) {
        List<String> polindroms = new ArrayList<String>();
        long maxPolindromSize = MAX_POLINDROME_SIZE;

        for (String str : words) {
            if (isPalindrome(str)) {
                polindroms.add(str);
                System.out.println("Polindrome found = " + str);
                if (str.length() > maxPolindromSize) {
                    maxPolindromSize = str.length();
                }
            }
        }

        String maxWord = findMaxPolindromeSize(polindroms);
        System.out.println("First max word = " + maxWord);

        return polindroms.stream()
                .filter(p -> p.length() >= maxWord.length())
                .sorted()
                .collect(Collectors.toList());
    }


    public static Boolean isPalindrome(String s) {
        if (s.equals(reverseString(s))) {
            return true;
        } else {
            return false;
        }
    }


    public static String reverseString(String s){
        String a = "";
        for (int i = s.length() - 1; i >= 0; --i)
            a += s.charAt(i);
        return a;
    }


    public static String findMaxPolindromeSize(List<String> words) {
        return words.stream()
                .max(Comparator.comparing(String::valueOf))
                .get();
    }
}
