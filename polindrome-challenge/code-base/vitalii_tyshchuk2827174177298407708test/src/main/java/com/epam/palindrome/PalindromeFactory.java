package com.epam.palindrome;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

public class PalindromeFactory {

    public static PalindromeFinder getPalindromeFinder(File file, boolean parallel, boolean line) throws IOException {

        if (line) {
            return new LinePalindromeFinder(file, parallel);
        } else {
            return new SimplePalindromeFinder(file, parallel);
        }

    }
}
