package by.yauheniy.lepkovich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// want to show that I know singleton :)
// but I will not create singletons for utils in future)
public class FileUtil {

    private FileUtil() {

    }

    private static class FileUtilInstance {
        private static final FileUtil INSTANCE = new FileUtil();
    }

    public static FileUtil getInstance() {
        return FileUtilInstance.INSTANCE;
    }

    public static String readText(String filePath) {
        try {
            return new String (Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void writePolidroms(String filePath, List<String> polidroms) {
        //need to init two resources to be sure that we close both of them
        try (OutputStreamWriter fileWriter = new FileWriter(filePath);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (String polidrom : polidroms) {
                writer.write(polidrom);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
