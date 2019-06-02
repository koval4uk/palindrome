package com.epam.hiring.service;


import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WordPalindromeServiceTest {

    @org.junit.Test
    public void findLongestPalindromes() {
        PalindromeService palindromeService = new WordPalindromeService();
        String inputString = "The longest palindrome by words is radar which you can use if you need. " +
                "The second longest palindrome is level " +
                "Also, I will add here one more palindrome like a deed.";
        Set<String> palindromes = palindromeService.findLongestPalindromes(inputString, true);
        assertEquals(2, palindromes.size());
        HashSet<String> expected = new HashSet<>();
        expected.add("radar");
        expected.add("level");
        assertEquals(expected, palindromes);
    }

    @org.junit.Test
    public void findLongestPalindromesCustomSplitter() {
        PalindromeService palindromeService = new WordPalindromeService();
        String inputString = "The longest palindrome by words is radar which you can use if you need. " +
                "The second longest palindrome is level " +
                "Also, I will add here one more palindrome like a deed.";
        Set<String> palindromes = palindromeService.findLongestPalindromes(inputString, false, new String[]{" ", "\t"});
        assertEquals(2, palindromes.size());
        HashSet<String> expected = new HashSet<>();
        expected.add("radar");
        expected.add("level");
        assertEquals(expected, palindromes);
    }


    @org.junit.Test
    public void findLongestPalindrome() {
        PalindromeService palindromeService = new WordPalindromeService();
        String inputString = "The longest palindrome by words is which you can use if you need. " +
                "The second longest palindrome is level " +
                "Also, I will add here one more palindrome like a deed.";
        Set<String> palindromes = palindromeService.findLongestPalindromes(inputString, false, new String[]{" ", "\t"});
        assertEquals(1, palindromes.size());
        HashSet<String> expected = new HashSet<>();
        expected.add("level");
        assertEquals(expected, palindromes);
    }

    @org.junit.Test
    public void findPalindrome() {
        PalindromeService palindromeService = new WordPalindromeService();
        String inputString = "The longest palindrome by words is which you can use if you need. " +
                "The second longest palindrome is " +
                "Also, I will add here one more palindrome like a deed.";
        Set<String> palindromes = palindromeService.findLongestPalindromes(inputString, false, new String[]{" ", "\t"});
        assertEquals(1, palindromes.size());
        HashSet<String> expected = new HashSet<>();
        expected.add("deed");
        assertEquals(expected, palindromes);
    }

    @org.junit.Test
    public void findPalindromeNotFound() {
        PalindromeService palindromeService = new WordPalindromeService();
        String inputString = "НЕТУ!";
        Set<String> palindromes = palindromeService.findLongestPalindromes(inputString, false, new String[]{" ", "\t"});
        assertTrue(palindromes.isEmpty());
    }
}
