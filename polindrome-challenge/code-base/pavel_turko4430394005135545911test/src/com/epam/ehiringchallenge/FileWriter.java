package com.epam.ehiringchallenge;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileWriter {


    public static void writeFile(String filename, List<String> words)throws IOException {
        Path file = Paths.get(filename);
        Files.write(file, words, Charset.forName("UTF-8"));
    }
}
