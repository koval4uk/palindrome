package com.github.kovalchuk;

import java.text.BreakIterator;
import java.util.HashSet;
import java.util.Set;

class TextService {

    Set<String> getWords(String text) {
        Set<String> words = new HashSet<>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }
        return words;
    }

}
