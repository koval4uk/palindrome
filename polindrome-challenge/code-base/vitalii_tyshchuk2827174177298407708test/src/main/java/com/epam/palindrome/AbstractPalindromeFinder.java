package com.epam.palindrome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractPalindromeFinder implements PalindromeFinder {

    private File inputFile;

    private Map<String, String> lines;

    private boolean parallel;

    AbstractPalindromeFinder(File inputFile, boolean parallel) throws IOException {
        this.inputFile = inputFile;
        this.lines = readFile();
        this.parallel = parallel;
    }

    public abstract List<Palindrome> search();

    private Map<String, String> readFile() throws IOException {
        final Map<String, String> lines = new HashMap<>();
        final BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));

        int count = 0;
        String line;
        while ((line = fileReader.readLine()) != null) {
            lines.put(count + ":" + line, new StringBuilder(line).reverse().toString());
            count++;
        }

        return lines;
    }

    protected File getInputFile() {
        return inputFile;
    }

    protected Map<String, String> getLines() {
        return lines;
    }

    protected boolean isParallel() {
        return parallel;
    }
}
