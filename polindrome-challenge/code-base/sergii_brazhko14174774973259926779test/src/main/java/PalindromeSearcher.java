import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PalindromeSearcher {

    public void searchPalindromeAndSaveToFile(String inputFile, String outputFile) {
        Stream<String> stringStream = parseFile(new File(inputFile));

//        stringStream = stringStream.filter(this::isPalindrome);
        writeStringsToFile(new File(outputFile), stringStream.filter(this::isPalindrome));
    }

    private Stream<String> parseFile(File file) {
        List<String> list = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                list.addAll(new ArrayList<String>(Arrays.asList(strLine.split(" "))));
            }
            br.close();
            fstream.close();
        } catch (IOException e) {
            System.out.println("File Reading Error. File " + file.getAbsolutePath());
        }
        Stream<String> stream = list.stream();
        return stream;
    }

    private void writeStringsToFile(File outputFile, Stream<String> stream) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            stream.forEach(st -> {
                try {
                    System.out.println(st);
                    bw.write(st);
                } catch (IOException e) {

                }
            });
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("File Reading Error. File " + outputFile.getAbsolutePath());
        }

    }


    public boolean isPalindrome(String string) {
        boolean isPalindrome = false;
        if (string.length() > 1) {
            isPalindrome = true;
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != chars[chars.length - 1 - i]) {
                    isPalindrome = false;
                    break;
                }
            }
        }
        return isPalindrome;
    }
}
