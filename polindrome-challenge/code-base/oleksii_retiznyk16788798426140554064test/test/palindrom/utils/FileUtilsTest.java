package palindrom.utils;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileUtilsTest {

    public FileUtilsTest() {
    }

    @Test
    public void readStrings() throws FileNotFoundException {
        List<String> strings = FileUtils.readStrings("testResources/TestFile");
        assert strings.size()==1;
        assertEquals("TestFile for FileUtils test;", strings.get(0));
    }

    @Test(expected = FileNotFoundException.class)
    public void readStringsNotExists() throws FileNotFoundException {
        FileUtils.readStrings("testResources/Non-existingFile");
    }

    @Test
    public void writeToFile() throws IOException {
        String message = "Secret message", filePath = "testResources/TestWriteFile";
        FileUtils.writeToFile(message, filePath);
        assertEquals(message, new String(Files.readAllBytes(Paths.get(filePath))));
    }
}