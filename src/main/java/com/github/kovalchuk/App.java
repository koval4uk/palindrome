package com.github.kovalchuk;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class App {
    //    final static Logger logger = Logger.getLogger(App.class);
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
//            logger.error("Start in TEST_MODE");
            args = new String[]{"input.txt", "output.txt"};
        }

        if (args.length == 2) {
            Path inputPath = Paths.get(args[0]);

            File inputFile = inputPath.toFile();

            if (inputFile.exists()) {
//                logger.debug("Start processing file \n");

                Set<String> words = new HashSet<>();
                try {
                    Files.lines(inputFile.toPath()).forEach(line -> {
                        words.addAll(getWords(line));
//                        logger.debug(line);
                    });

//                    logger.debug("Finish processing file, find '" + words.size() + "'words\n");

                    // find palindrome
                    SortedSet<String> palindromes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                    for (String word : words) {
                        if (isPalindromString(word) && word.length() >= 2) {
                            palindromes.add(word);
                        }

                    }
//                    logger.debug("Find '" + palindromes.size() + "'palindromes\n");

//                    logger.debug("Start writting file");

                    Collections.sort(new ArrayList<>(palindromes), Comparator.reverseOrder());

                    Path outputPath = Paths.get(args[1]);
                    Files.write(outputPath, String.join("\n", palindromes).getBytes());


                } catch (IOException e) {
                    e.printStackTrace();
                }

//                logger.error("!!!!!!!!!");


            }

        } else {
//            logger.error("Invalid input params. Need input: [java -jar Palindrom.jar \"input.txt\" \"result.txt\"]");
        }

//        logger.info("End task");
    }

    public static boolean isPalindromString(String text) {
        String reverse = reverse(text);
        return text.equals(reverse);
    }

    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
    }

    public static Set<String> getWords(String text) {
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
