package com.epam.palindrome;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinePalindromeFinder extends AbstractPalindromeFinder {

    public LinePalindromeFinder(File inputFile, boolean parallel) throws IOException {
        super(inputFile, parallel);
    }

    public List<Palindrome> search() {

        Pattern pattern = Pattern.compile("([-1]+|^)+([1]+[-1]+)*([-1]+|$)");

        return this.getLines().entrySet().stream().map(pair -> {
            Set<String> linesMatched = new HashSet<>();

            final char[] straight = pair.getKey().toCharArray();
            final char[] flipped = pair.getValue().toCharArray();

            int[] mask = IntStream.range(0, straight.length).map(index -> {

                if (Character.isSpaceChar(straight[index])
                        || !Character.isAlphabetic(straight[index])
                        || !Character.isDigit(straight[index])) {
                    return 0;
                }

                if (straight[index] == flipped[index]) {
                    return 1;
                }

                return -1;

            }).toArray();

            String stringMask = Arrays.stream(mask).boxed().map(Object::toString)
                    .collect(Collectors.joining(""));
            Matcher matcher = pattern.matcher(stringMask);

            while (matcher.find()) {
                linesMatched.add(pair.getKey().substring(matcher.start(), matcher.end()));
            }

            return linesMatched.stream().map(line -> new Palindrome(line.trim(), line.length()));

        }).flatMap(Function.identity())
                .sorted(Comparator.comparing(Palindrome::getLength))
                .collect(Collectors.toList());
    }
}
