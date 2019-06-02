package com.epam.palindrome;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PalindromeApplication {

    public static void main(String[] args) {
        if (args.length < 2 ) {
            return;
        }
        try {
            List<Palindrome> palindromes = new LinkedList<>();
            if (args.length == 2) {
                palindromes = PalindromeFactory.getPalindromeFinder(new File(args[0]), false, false).search();
            }

            if (args.length == 3) {
                boolean paralell = Boolean.parseBoolean(args[2]);
                palindromes = PalindromeFactory.getPalindromeFinder(new File(args[0]), paralell, false).search();
            }

            if (args.length == 4) {
                boolean paralell = Boolean.parseBoolean(args[2]);
                boolean line = Boolean.parseBoolean(args[3]);
                palindromes = PalindromeFactory.getPalindromeFinder(new File(args[0]), paralell, line).search();
            }

            File file = new File(args[1]);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
