package com.epam.hiring.service;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sergiy Dyrda created on 01.06.2019
 */
public class WordPalindromeService implements PalindromeService {

    private static final String DEFAULT_SPLITTERS = "[\\s\\t.,:_]+";

    @Override
    public Set<String> findLongestPalindromes(String line, boolean caseSensitive) {
        return findLongestPalindromes(line, caseSensitive, DEFAULT_SPLITTERS);
    }

    @Override
    public Set<String> findLongestPalindromes(String item, boolean caseSensitive, String[] splitters) {
        return findLongestPalindromes(item, caseSensitive, compileSplitters(splitters));
    }

    private Set<String> findLongestPalindromes(String line, boolean caseSensitive, String splitters) {
        if (line == null || line.isEmpty()) {
            return Collections.emptySet();
        }
        return Arrays.stream(line.split(splitters))
                .map(word -> caseSensitive ? word : word.toLowerCase())
                .map(word -> word.replaceAll("[.,]", ""))
                .map(word -> new Pair(word, findPalindromeLength(word)))
                .filter(pair -> pair.palindromeLength > 1)
                .collect(CustomHashSet::new, (container, value) -> {
                    if (value.palindromeLength == container.palindromeLength) {
                        container.add(value.word);
                    }
                    if (value.palindromeLength > container.palindromeLength) {
                        container.clear();
                        container.add(value.word);
                    }
                }, HashSet::addAll);
    }

    private String compileSplitters(String[] splitters) {
        return Arrays.stream(splitters)
                .collect(Collectors.joining("", "[", "]+"));

    }

    private int findPalindromeLength(String word) {
        if (word == null || word.isEmpty()) {
            return -1;
        }
        if (word.length() == 1) {
            return 1;
        }
        boolean isPalindrome = true;
        char[] chars = word.toCharArray();
        int begin = 0;
        int end = word.length() - 1;
        while (end > begin) {
            if (chars[begin] != chars[end]) {
                isPalindrome = false;
            }
            ++begin;
            --end;
        }

        if (isPalindrome) {
            return word.length();
        } else {
            return 0;
        }
    }

    @AllArgsConstructor
    private class Pair {
        String word;
        int palindromeLength;

    }

    private class CustomHashSet extends HashSet<String> {
        int palindromeLength = -1;

        @Override
        public boolean add(String e) {
            palindromeLength = e.length();
            return super.add(e);
        }

        @Override
        public void clear() {
            palindromeLength = -1;
            super.clear();
        }
    }
}
