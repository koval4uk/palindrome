package ihor.makarchuk.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

    public String readFromFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(text::append);
        return text.toString();
    }

    public void writeToFile(String filePath, String text) throws IOException {
        Files.write(Paths.get(filePath), text.getBytes());
    }
}
