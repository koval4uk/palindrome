package palindrome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newBufferedWriter;

public class PalindromeFinder {

    public static void main(String[] args) {
        String inputFile = args[0];
        String outputFile = args[1];
        PalindromeFinder finder = new PalindromeFinder();
        List<String> foundPalindromes = finder.findPalindrome(Paths.get(inputFile));
        try (BufferedWriter writer = newBufferedWriter(Paths.get(outputFile))) {
            for (String palindrome : foundPalindromes) {
                writer.write(palindrome);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Can't write to path: '" + outputFile + "'. Exception: " + e);
        }
    }

    private boolean isPalindrome(String input) {
        int size = input.length();
        int half = size / 2;
        for (int i = 0; i < half; i++) {
            if (input.charAt(i) != input.charAt(size - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public List<String> findPalindrome(Path path) {
        Set<String> palindromes = new TreeSet<>();
        int maxLength = 0;
        try (BufferedReader reader = newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^\\w']+");
                for (String word : words) {
                    if (isPalindrome(word) && word.length() >= maxLength) {
                        if (word.length() > maxLength) {
                            palindromes.clear();
                            maxLength = word.length();
                        }
                        palindromes.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Can't parse lines from path: '" + path + "'. Exception: " + e);
        }
        return new ArrayList<>(palindromes);
    }



}
