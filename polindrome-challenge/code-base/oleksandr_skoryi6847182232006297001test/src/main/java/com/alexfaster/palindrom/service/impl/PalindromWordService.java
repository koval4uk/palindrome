package com.alexfaster.palindrom.service.impl;

import com.alexfaster.palindrom.service.PalindromService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromWordService extends PalindromService {

    public List<String> findAllPalindromsInLine(final String normalizedText) {
        final String[] words = normalizedText.split("\\s");
        return Arrays.stream(words)
                .filter(this::isPalindrom)
                .filter(word -> word.length() > 0)
                .distinct()
                .collect(Collectors.toList());
    }
}
