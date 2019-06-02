/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koliadenko.palindrom;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vova
 */
public class TextUtilsTest {

    public TextUtilsTest() {
    }

    @org.junit.Test
    public void testMainResult() {
        System.out.println("findPalindroms");
        String text = "There you will find nothing "
                + "I step on no pets and here you can find the first multi-word palindrome. "
                + "The longest palindrome by words is radar which you can use if you need. "
                + "Also, I will add here one more palindrome like a deed. "
                + "The second longest palindrome is level "
                + "Remember that you need to sort words before output "
                + " "
                + "Enjoy your coding. Good luck!";
        String expResult = "level\n"
                + "radar";
        String result = TextUtils.findPalindroms(text);
        assertEquals(expResult, result);

    }

    @org.junit.Test
    public void testIsPalindrom() {
        System.out.println("isPalindrom");
        String word = "radar";
        boolean expResult = true;
        boolean result = TextUtils.isPalindrom(word);
        assertEquals(expResult, result);

        word = "radara";
        expResult = false;
        result = TextUtils.isPalindrom(word);
        assertEquals(expResult, result);

        word = "lol";
        expResult = true;
        result = TextUtils.isPalindrom(word);
        assertEquals(expResult, result);

        word = "lol-lol";
        expResult = true;
        result = TextUtils.isPalindrom(word);
        assertEquals(expResult, result);

    }

    @org.junit.Test
    public void testEmptyNotPalindrom() {
        System.out.println("isPalindrom");
        String word = "";
        boolean expResult = false;
        boolean result = TextUtils.isPalindrom(word);
        assertEquals(expResult, result);
    }
}
