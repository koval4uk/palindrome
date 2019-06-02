package com.alexfaster.palindrom.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class PalindromService {

    public List<String> findLongestPalindroms(final List<String> palindroms) {
        final int sizeOfLongestPalindrom = findSizeOfLongestPalindrome(palindroms);
        return filterPalindromWithLength(palindroms, sizeOfLongestPalindrom);
    }

    public List<String> findPalindroms(final String text) {

        if (text == null || text.length() == 0) {
            return Collections.emptyList();
        }

        final String normalizedText = normalizeText(text);

        final List<String> palindroms = findAllPalindromsInLine(normalizedText);

        final int sizeOfLongestPalindrom = findSizeOfLongestPalindrome(palindroms);

        return filterPalindromWithLength(palindroms, sizeOfLongestPalindrom);
    }

    public abstract List<String> findAllPalindromsInLine(final String text);

    private int findSizeOfLongestPalindrome(final List<String> palindroms) {
        return palindroms.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    private List<String> filterPalindromWithLength(
            final List<String> palindroms,
            final int sizeOfLongestPalindrom
    ) {
        return palindroms.stream()
                .filter(palindrom -> Objects.equals(palindrom.length(), sizeOfLongestPalindrom))
                .sorted()
                .collect(Collectors.toList());
    }

    private String normalizeText(final String text) {
        return text.replaceAll("[^a-zA-Z0-9 -]", "")
                .replaceAll("\\s+", " ")
                .trim();
    }

    protected boolean isPalindrom(final String s) {
        final String reversedString = new StringBuilder(s).reverse()
                .toString();
        return Objects.equals(s, reversedString);
    }

}
