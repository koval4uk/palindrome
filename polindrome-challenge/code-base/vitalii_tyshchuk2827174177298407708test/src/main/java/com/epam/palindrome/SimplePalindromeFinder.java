package com.epam.palindrome;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplePalindromeFinder extends AbstractPalindromeFinder {

    public SimplePalindromeFinder(File inputFile, boolean parallel) throws IOException {
        super(inputFile, parallel);
    }

    public List<Palindrome> search() {
        return this.getLines().entrySet().stream().map(pair -> {
            final List<String> straight = Arrays.asList(pair.getKey().split("\\s"));
            final List<String> flipped = Arrays.asList(pair.getValue().split("\\s"));
            return straight.stream().distinct().filter(flipped::contains)
                    .map(match -> new Palindrome(match, match.length()));
        }).flatMap(Function.identity())
          .sorted(Comparator.comparing(Palindrome::getLength))
          .collect(Collectors.toList());
    }
}
