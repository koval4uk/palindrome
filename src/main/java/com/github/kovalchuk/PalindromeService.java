package com.github.kovalchuk;

import org.apache.log4j.Logger;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class PalindromeService {
    private final static Logger logger = Logger.getLogger(PalindromeService.class);

    SortedSet<String> findPalindromes(Set<String> words) {
        logger.debug("Finish processing file, find '" + words.size() + "'words\n");
        SortedSet<String> palindromes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        PalindromeService palindromeService = new PalindromeService();
        for (String word : words) {
            if (palindromeService.isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        logger.debug("Find '" + palindromes.size() + "'palindromes\n");
        return palindromes;
    }

    private boolean isPalindrome(String text) {
        if (text.length() >= 2) {
            String reverse = reverse(text);
            return text.equals(reverse);
        } else {
            return false;
        }
    }

    private String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
    }
}
