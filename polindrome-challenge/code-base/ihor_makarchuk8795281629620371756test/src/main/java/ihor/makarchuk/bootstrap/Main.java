package ihor.makarchuk.bootstrap;

import ihor.makarchuk.exceptions.EmptyTextException;
import ihor.makarchuk.exceptions.PalindromsNotFoundException;
import ihor.makarchuk.logic.Palindrom;
import ihor.makarchuk.util.FileOperations;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            printUsageHelp();
            return;
        }
        FileOperations fileOps = new FileOperations();
        Palindrom palindrom = new Palindrom();

        try {
            String inputText = fileOps.readFromFile(args[0]);
            fileOps.writeToFile(args[1], palindrom.findLongestPalindromInText(inputText));
        } catch (IOException e) {
            System.out.println("File(-s) not found. Check your path.");
        } catch (EmptyTextException e) {
            System.out.println("Input text doesn't contain any characters.");
        } catch (PalindromsNotFoundException e) {
            System.out.println("Given text doesn't contain palindroms");
        }
    }

    private static void printUsageHelp() {
        System.out.println("Arguments should be: <input.txt> <output.txt>");
    }

}
