/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koliadenko.palindrom;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vova
 */
public class FileUtils {

    static String readFileAsString(String filename) {

        Path filePath = Paths.get(filename);

        Charset charset = Charset.forName("UTF-8");

        try {
            List<String> lines = Files.readAllLines(filePath, charset);
            //System.out.println(lines);
            String fullResult = String.join(" ", lines);
            return fullResult;
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, "File not found or encoding error", ex);
        }
        return "";
    }

}
