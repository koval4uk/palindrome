package com.epam.ehiringchallenge;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String inputFile = args[0]; //"input.txt"
        String outputFile = args[1]; //"output.txt"

        List<String> words = FileReader.readFile(inputFile);

        List<String> resultWords = PolindromProcessor.getListMaxPolindromes(words);
        System.out.println("Max Polindroms:");
        resultWords.stream()
                .forEach(System.out::println);

        FileWriter.writeFile(outputFile, resultWords);
    }

}