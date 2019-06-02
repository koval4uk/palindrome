package com.salnikov.epam;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;


public class Application {

    public static void main(String args[]) {

        if(args == null || args.length == 2) {
            throw new IllegalArgumentException("Argument might contain 'input' and 'output' paths");
        }

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {

            reader.lines()
                    .flatMap(s -> Arrays.stream(s.split("\\s")))
                    .filter(Application::isPalindrome)
                    .reduce(BinaryOperator.maxBy(Comparator.comparing(String::length)))
                    .ifPresent(s -> {
                        try {
                            writer.write(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean isPalindrome(String word) {
        if(StringUtils.isBlank(word)) {
            return false;
        }

        return word.equals(StringUtils.reverse(word));
    }
}
