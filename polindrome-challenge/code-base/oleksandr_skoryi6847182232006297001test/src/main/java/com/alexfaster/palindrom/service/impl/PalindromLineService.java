package com.alexfaster.palindrom.service.impl;

import com.alexfaster.palindrom.service.PalindromService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PalindromLineService extends PalindromService {

    @Override
    public List<String> findAllPalindromsInLine(final String normalizedText) {
        final List<String> palindromes = new ArrayList<>();
        for (int i = 0; i < normalizedText.length(); i++) {
            palindromes.addAll(findPalindromes(normalizedText, i, i + 1));
            palindromes.addAll(findPalindromes(normalizedText, i, i));
        }
        return palindromes.stream()
                .map(String::trim)
                .distinct()
                .collect(Collectors.toList());
    }

    private Set<String> findPalindromes(String input, int low, int high) {
        Set<String> result = new HashSet<>();
        while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
            result.add(input.substring(low, high + 1));
            low--;
            high++;
        }
        return result;
    }

}
