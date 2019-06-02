/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koliadenko.palindrom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author vova
 */
public class TextUtils {

    static String findPalindroms(String text) {

        int maxLengtz = 0;//max finded palindrom
        String[] words = text.split("[ .,!?:;]");
        List<String> palindroms = new ArrayList<>();
        for (String word : words) {
            if (isPalindrom(word)) {
                palindroms.add(word);
                maxLengtz = Math.max(maxLengtz, word.length());
            }
        }
        //System.out.println(palindroms);

        final int maxLengtz2 = maxLengtz;
        String fullTextPalindroms = palindroms
                .stream().parallel()
                //я знаю, что профит тут мал или отрицателен
                .filter((String s) -> s.length() >= maxLengtz2) //remoove short palindroms
                .sorted()
                .collect(Collectors.joining("\n"));

        //System.out.println(fullTextPalindroms);
        return fullTextPalindroms;
    }

    static boolean isPalindrom(String word) {
        if (word.isEmpty()) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(word);
        return word.equals(stringBuilder.reverse().toString());
    }
}
