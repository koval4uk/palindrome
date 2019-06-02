package com.github.kovalchuk;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class App {
    private final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        args = setTestModeParams(args);

        if (args.length == 2) {
            Path inputPath = Paths.get(args[0]);
            File inputFile = inputPath.toFile();
            if (inputFile.exists()) {
                logger.debug("Start processing file \n");
                try {
                    FileHelper fileHelper = new FileHelper();
                    Set<String> words = fileHelper.getWordsFromFile(inputFile);
                    PalindromeService palindromeService = new PalindromeService();
                    SortedSet<String> palindromes = palindromeService.findPalindromes(words);
                    fileHelper.createFileWithContent(palindromes, Paths.get(args[1]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            logger.error("Invalid input params. Need input: [java -jar Palindrom.jar \"input.txt\" \"result.txt\"]");
        }
        logger.info("End task");
    }

    private static String[] setTestModeParams(String[] args) {
        // VM options -DtestMode=true
        String testModeProp = System.getProperty("testMode");
        if (testModeProp != null) {
            boolean testMode = Boolean.valueOf(testModeProp);
            if (testMode) {
                logger.error("Start in testMode");
                args = new String[]{"input.txt", "output.txt"};
            }
        }
        return args;
    }
}
