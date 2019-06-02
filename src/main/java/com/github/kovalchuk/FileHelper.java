package com.github.kovalchuk;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

class FileHelper {
    private final static Logger logger = Logger.getLogger(FileHelper.class);

    Set<String> getWordsFromFile(File inputFile) throws IOException {
        TextService textService = new TextService();
        Set<String> words = new HashSet<>();
        Files.lines(inputFile.toPath()).forEach(line -> {
            words.addAll(textService.getWords(line));
            logger.debug(line);
        });
        return words;
    }

    void createFileWithContent(SortedSet<String> palindromes, Path outputPath) throws IOException {
        logger.debug("Start writing file");
        Files.write(outputPath, String.join("\n", palindromes).getBytes());
    }
}
