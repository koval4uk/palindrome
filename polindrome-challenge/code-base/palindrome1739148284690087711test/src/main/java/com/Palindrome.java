package com;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.service.FileWriterService;
import com.service.FileWriterServiceImpl;
import com.service.PalindromeSearcherService;
import com.service.SimplePalindromeSearcherServiceImpl;
import com.service.SimpleTextReaderServiceImpl;
import com.service.TextReaderService;

public class Palindrome {

    private static TextReaderService textReaderService = new SimpleTextReaderServiceImpl();
    private static PalindromeSearcherService searcher = new SimplePalindromeSearcherServiceImpl();
    private static FileWriterService writer = new FileWriterServiceImpl();

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            Stream<String> stringStream = textReaderService.readFile("src/main/java/com/" + args[0]);
            List<String> longest = searcher.findLongest(searcher.find(stringStream));
            List<String> toWrite = longest.stream()
                    .map(str -> str + System.getProperty("line.separator")).collect(
                    Collectors.toList());

            writer.write(String.join(" ", toWrite), "src/main/java/com/" + args[1]);

        }
    }
}
