package com.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplePalindromeSearcherServiceImpl implements PalindromeSearcherService {
    @Override
    public List<String> find(Stream<String> line) {
        return line.flatMap(words -> Stream.of(words.split("\\W+")))
                .filter(word -> istPalindrome(word.toCharArray()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findLongest(List<String> palindromes) {

        List<String> sorted = palindromes.stream()
                .sorted((e1, e2) -> e1.length() > e2.length() ? -1 : 1)
                .collect(Collectors.toList());

        int longestPalindromeLength = sorted.get(0).length();
        List<String> longestPalindromes = sorted.stream()
                .filter(p -> p.length() == longestPalindromeLength)
                .collect(Collectors.toList());

        longestPalindromes.sort(Comparator.naturalOrder());

        return longestPalindromes;
    }

    public static boolean istPalindrome(char[] word) {
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
