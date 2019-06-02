package ihor.makarchuk.logic;

import ihor.makarchuk.exceptions.EmptyTextException;
import ihor.makarchuk.exceptions.PalindromsNotFoundException;

import java.util.*;

public class Palindrom {

    private static final String SPACE_DELIMITER = " ";
    private static final String NON_ALPHABETIC_SYMBOLS_REGEX = "[^a-zA-Z0-9\\s[\\r\\n]]";

    public String findLongestPalindromInText(String text) throws EmptyTextException {
        Set<String> palindroms = findPalindromsInText(text);

        if (palindroms.isEmpty()) {
            throw new PalindromsNotFoundException();
        }
        Optional<String> longestPalindrom = palindroms.stream().max(Comparator.comparingInt(String::length));
        return longestPalindrom.get();
    }

    public Set<String> findPalindromsInText(String text) {
        if (text.isEmpty()) {
            throw new EmptyTextException();
        }
        Set<String> palindroms = new HashSet<>();
        text = removeNotAlphabeticCharacters(text);
        List<String> wordsFromText = Arrays.asList(text.split(SPACE_DELIMITER));
        wordsFromText.forEach(word -> {
            if (word.length() < 2) {
                return;
            }
            StringBuilder reversedWord = new StringBuilder(word).reverse();

            if (word.equals(reversedWord.toString())) {
                palindroms.add(word);
            }
        });
        return palindroms;
    }

    private String removeNotAlphabeticCharacters(String text) {
        return text.replaceAll(NON_ALPHABETIC_SYMBOLS_REGEX, SPACE_DELIMITER);
    }


}
