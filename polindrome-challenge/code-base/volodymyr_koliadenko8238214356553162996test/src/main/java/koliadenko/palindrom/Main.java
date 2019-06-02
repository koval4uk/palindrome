/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koliadenko.palindrom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import static koliadenko.palindrom.FileUtils.readFileAsString;
import static koliadenko.palindrom.TextUtils.findPalindroms;

/**
 *
 * @author vova
 */
public class Main {

    final static Logger LOGGER = Logger.getLogger("Main.class");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length < 2) {
            LOGGER.log(Level.SEVERE, "No filenames!");
        } else {
            String inputFileName = args[0];
            String outputFileName = args[1];

            String text = readFileAsString(inputFileName);

            String longestPalindroms = findPalindroms(text) + "\n";
            /*For automation scripts to work it is desirable, but not mandatory, 
            to file be ended with newline symbol (other words - last line in the file should be empty*/
            try {
                Files.write(Paths.get(outputFileName), longestPalindroms.getBytes());
                //System.out.println("OK");
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }

}
