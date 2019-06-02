package com.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void write(String result, String fileName) throws IOException {
        Files.write(Paths.get(fileName), result.getBytes());
    }
}
