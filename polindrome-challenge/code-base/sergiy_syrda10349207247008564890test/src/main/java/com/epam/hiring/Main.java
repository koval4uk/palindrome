package com.epam.hiring;

import com.epam.hiring.service.PalindromeService;
import com.epam.hiring.service.WordPalindromeService;
import com.epam.hiring.util.CommandOptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.rainerhahnekamp.sneakythrow.Sneaky.sneaked;

/**
 * @author Sergiy Dyrda created on 01.06.2019
 */
public class Main {


    public static void main(String[] args) {
        try {
            CommandOptions commandOptions = new CommandOptions(args);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(commandOptions.getOutFilePath())))) {
                List<String> lines = Files.readAllLines(Paths.get(commandOptions.getInputFilePath()));
                PalindromeService palindromeService = new WordPalindromeService();
                lines.stream()
                        .flatMap(line -> palindromeService.findLongestPalindromes(line, false).stream())
                        .forEach(palindrome -> sneaked(() -> {
                            writer.write(palindrome);
                            writer.write("\n");
                        }).run());
                writer.flush();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
