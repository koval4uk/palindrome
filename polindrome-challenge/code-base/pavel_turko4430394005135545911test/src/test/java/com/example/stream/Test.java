package test.java.com.example.stream;


import com.epam.ehiringchallenge.PolindromProcessor;


public class Test {

    public void testIsPolindrome() {
        assert(PolindromProcessor.isPalindrome("abba"));
    }

    public void testIsNotPolindrome() {
        assert(PolindromProcessor.isPalindrome("work"));
    }
}