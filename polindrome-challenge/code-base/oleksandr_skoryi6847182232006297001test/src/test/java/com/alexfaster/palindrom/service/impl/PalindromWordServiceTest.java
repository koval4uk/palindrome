package com.alexfaster.palindrom.service.impl;

import com.alexfaster.palindrom.service.PalindromService;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;

public class PalindromWordServiceTest {

    private PalindromService palindromService;

    @Before
    public void init() {
        palindromService = new PalindromWordService();
    }

    @Test
    public void verifyThatListOfPalindromsShowsCorrectly() {

        final String text = "There you will find nothing " +
                "I step on no pets and here you can find the first multi-word palindrome. " +
                "The longest palindrome by words is radar which you can use if you need. " +
                "Also, I will add here one more palindrome like a deed. " +
                "The second longest palindrome is level " +
                "Remember that you need to sort words before output " +
                "Enjoy your coding. Good luck! ";

        final List<String> longestPalindroms = palindromService.findPalindroms(text);

        assertThat(
                longestPalindroms,
                Is.is(Arrays.asList("level", "radar"))
        );
    }

    @Test
    public void verifyThatEmptyTextHandledCorrectly() {

        final String text = "";

        final List<String> longestPalindroms = palindromService.findPalindroms(text);

        assertThat(
                longestPalindroms,
                Is.is(Collections.emptyList())
        );
    }

    @Test
    public void verifyThatMultiSpacedTextHandledCorrectly() {

        final String text = "aa     aa bbb   bbb";

        final List<String> longestPalindroms = palindromService.findPalindroms(text);

        assertThat(
                longestPalindroms,
                Is.is(Collections.singletonList("bbb"))
        );
    }

    @Test
    public void verifyThatNullHandledCorrectly() {

        final String text = null;

        final List<String> longestPalindroms = palindromService.findPalindroms(text);

        assertThat(
                longestPalindroms,
                Is.is(Collections.emptyList())
        );
    }

    @Test
    public void verifyThatLongestPalindromeFound() {

        final List<String> palindroms = Arrays.asList(
                "radar",
                "level",
                "aga",
                "lol"
        );

        final List<String> longestPalindroms = palindromService.findLongestPalindroms(palindroms);

        assertThat(
                longestPalindroms,
                Is.is(Arrays.asList("level", "radar"))
        );
    }
}
