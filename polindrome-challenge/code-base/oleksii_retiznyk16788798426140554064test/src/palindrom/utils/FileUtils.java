package palindrom.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtils {
    public static List<String> readStrings(String filePath) throws FileNotFoundException {
            Path inputFile = Paths.get(filePath);
            if(!Files.exists(inputFile)) throw new FileNotFoundException("Requested input file wasn't found!");
        try {
            return Files.readAllLines(inputFile, StandardCharsets.UTF_8);
        }catch (IOException e){
            throw new RuntimeException("Got exception while reading file. File isn't readable?", e);
        }
    }

    public static void writeToFile(String message, String filePath){
        try {
            Files.write(Paths.get(filePath), message.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }catch (IOException e){
            throw new RuntimeException("Can't create or write to file, are permissions correct?", e);
        }
    }
}
