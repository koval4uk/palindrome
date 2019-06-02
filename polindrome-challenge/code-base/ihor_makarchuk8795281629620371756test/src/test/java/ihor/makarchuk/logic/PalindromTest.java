package ihor.makarchuk.logic;

import ihor.makarchuk.exceptions.EmptyTextException;
import ihor.makarchuk.exceptions.PalindromsNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Set;

public class PalindromTest {

    private Palindrom palindrom;
    private String text;

    @Before
    public void setUp() {
        palindrom = new Palindrom();
        text = "The longest palindrome by words is radar which you can use if you need.\n" +
                "Also, I will add here one more palindrome like a deed.\n" +
                "The second longest palindrome is level\n";
    }

    @Test
    public void testFindPalindromsInText() {
        Set<String> palindroms = palindrom.findPalindromsInText(text);
        assertEquals(3, palindroms.size());
        assertTrue(palindroms.contains("radar"));
        assertTrue(palindroms.contains("level"));
        assertTrue(palindroms.contains("deed"));
    }

    @Test
    public void testLongestPalindrom() {
        String expected = "radar";
        String actual = palindrom.findLongestPalindromInText(text);
        assertEquals(expected, actual);
    }

    @Test(expected = EmptyTextException.class)
    public void testFindPalindromsInEmptyText() {
        palindrom.findPalindromsInText("");
    }

    @Test(expected = PalindromsNotFoundException.class)
    public void testFindPalindromsNotFound() {
        palindrom.findLongestPalindromInText("random text");
    }

}
