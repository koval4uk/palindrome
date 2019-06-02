package com.service;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class PalindromeSearcherServiceImplTest {

    private String basePath = "src/test/resources/";
    PalindromeSearcherService service = new SimplePalindromeSearcherServiceImpl();

    @Test
    public void findOneOddPalindrome() throws IOException {
        //Given
        Stream<String> lines = Files.lines(Paths.get(basePath + "one_odd_palindrome.txt"));

        //When
        List<String> strings = service.find(lines);

        //Then
        assertEquals(strings.size(), 1);
        assertEquals(strings.get(0), "qwq");
    }

    @Test
    public void findOneEvenPalindrome() throws IOException {
        //Given
        Stream<String> lines = Files.lines(Paths.get(basePath + "one_even_palindrome.txt"));

        //When
        List<String> strings = service.find(lines);

        //Then
        assertEquals(strings.size(), 1);
        assertEquals(strings.get(0), "erre");
    }

    @Test
    public void findOneLongestPalindrome() throws IOException {
        //Given
        Stream<String> lines = Files.lines(Paths.get(basePath + "one_from_two_palindrome.txt"));

        //And
        List<String> palindromes = service.find(lines);

        //When
        List<String> longest = service.findLongest(palindromes);

        //Then
        assertEquals(longest.size(), 1);
        assertEquals(longest.get(0), "rrttrr");
    }

    @Test
    public void findTwoLongestPalindrome() throws IOException {
        //Given
        Stream<String> lines = Files.lines(Paths.get(basePath + "two_from_three_palindrome.txt"));

        //And
        List<String> palindromes = service.find(lines);

        //When
        List<String> longest = service.findLongest(palindromes);

        //Then
        assertEquals(longest.size(), 2);
        assertEquals(longest.get(0), "adda");
        assertEquals(longest.get(1), "bqqb");
    }
}
