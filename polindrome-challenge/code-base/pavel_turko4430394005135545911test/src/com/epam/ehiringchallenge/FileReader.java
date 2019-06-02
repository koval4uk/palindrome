package com.epam.ehiringchallenge;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private static String STRING_SEPARATOR = " ";

    public static List<String> readFile(String fileName) {
        return parseFile(new File(fileName));
    }

    private static List<String> parseFile(File file) {
        List<String> list = new ArrayList<>();
        try {
            FileInputStream streamInput = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(streamInput));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                list.addAll(new ArrayList<String>(Arrays.asList(strLine.split(STRING_SEPARATOR))));
            }
            br.close();
            streamInput.close();
        } catch (IOException e) {
            System.out.println("File Reading Error: " + file.getAbsolutePath());
        }
        Stream<String> stream = list.stream();
        return stream.collect(Collectors.toList());
    }

}
