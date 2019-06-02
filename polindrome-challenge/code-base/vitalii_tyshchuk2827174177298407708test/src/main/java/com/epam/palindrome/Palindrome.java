package com.epam.palindrome;

public class Palindrome {

    public Palindrome(String word, int length) {
        this.word = word;
        this.length = length;
    }

    private String word;

    private int length;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
