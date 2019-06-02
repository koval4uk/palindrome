package com.alexfaster.palindrom;

import com.alexfaster.palindrom.service.PalindromService;
import com.alexfaster.palindrom.service.impl.PalindromLineService;
import com.alexfaster.palindrom.service.impl.PalindromWordService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        if (args.length != 3) {
            throw new IllegalArgumentException("Incorrect number of input params\n" +
                    "Use java -jar Palindrom.jar \"input.txt\" \"result.txt\" \"algorithm(word,line)\"");
        }

        final String inputPath = args[0];
        final String outputPath = args[1];
        final String algorithm = args[2];

        final PalindromService palindromService;
        if ("line".equalsIgnoreCase(algorithm)) {
            palindromService = new PalindromLineService();
        } else if ("word".equalsIgnoreCase(algorithm)) {
            palindromService = new PalindromWordService();
        } else {
            throw new IllegalArgumentException("Algorithm not found");
        }
        final List<String> longestPalindroms = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {

            final List<String> palindroms = stream.map(palindromService::findPalindroms)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            longestPalindroms.addAll(palindromService.findLongestPalindroms(palindroms));

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getCause() + " " + ex.getMessage());
        }

        writeFile(outputPath, longestPalindroms);

    }

    private static void writeFile(final String outputPath, final List<String> longestPalindroms) {
        try {
            Files.write(Paths.get(outputPath), longestPalindroms);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error during file writing");
        }
    }
}
