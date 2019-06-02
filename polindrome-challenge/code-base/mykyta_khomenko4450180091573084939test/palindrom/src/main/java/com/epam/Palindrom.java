package com.epam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Palindrom
{
    private static final boolean MODE_DEFAULT = false;

    private static final boolean MODE_LINE = true;

    private static List<String> polindroms = new ArrayList<>();

    private boolean mode = MODE_DEFAULT;

    private static String input = "";

    private static String output = "";

    private static int maxLength = 0;

    public static void main(String[] args )
    {
        parseArgs(args);
        List<String> allLines;

        try {
            allLines = Files.readAllLines(Paths.get(input));
        } catch (IOException e) {
            throw new RuntimeException("Cannot access the input file specified!");
        }
        for (String line : allLines) {
            polindroms.addAll(findPalindromsInLine(line, false));
        }
        try {
            printResultsToFile(output, polindroms);
        } catch (IOException e) {
            System.out.println("Cannot access/modify the output file specified! Dumping results to console.");
            printResults();
        }
    }

    private static void parseArgs(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("Required arguments are missing!");
        }
        input = args[0];
        output = args[1];
    }

    private static void printResultsToFile(String output, List<String> lines) throws IOException {
        OutputStream os = null;
        if (lines.size() > 1) {
            Collections.sort(lines);
        }
        os = new FileOutputStream(new File(output));
            for (String line : lines){
                line += "\n";
                os.write(line.getBytes(), 0, line.length());
            }
        os.close();
    }

    private static void printResults() {
        for (String line : polindroms) {
            System.out.println(line);
        }
    }

    private static List<String> findPalindromsInLine(String line, boolean mode) {
        if (null == line && line.isEmpty()) {
            return Collections.emptyList();
        }
        String[] words;
        if (mode) {
            line = line.trim();
            words = new String[]{line};
        } else {
            words = line.split(" ");
        }
        int length = words.length;
        List<String> result = new ArrayList<>();

        for (int i=0; i<length; i++) {
            if (words[i].length() > 1 && isPalindrom(words[i]) && words[i].length() >= maxLength) {
                if (words[i].length() > maxLength) {
                    result.clear();
                }
                result.add(words[i]);
                maxLength = words[i].length();
            }
        };
        return result;
    }

    private static boolean isPalindrom(String word) {
        String reverse = new StringBuffer(word).reverse().toString();
        return reverse.equalsIgnoreCase(word);
    }
}
