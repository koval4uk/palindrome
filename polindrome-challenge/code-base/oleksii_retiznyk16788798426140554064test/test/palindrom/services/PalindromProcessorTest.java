package palindrom.services;

import org.junit.Test;
import palindrom.utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class PalindromProcessorTest {

    public PalindromProcessorTest() {
    }

    @Test
    public void processFile() throws FileNotFoundException {
        PalindromProcessor processor = new PalindromProcessor(FileUtils.readStrings("testResources/input.txt"));
        Map<Integer, List<String>> result = processor.processFile();
        assert result.size()==2;
        assert result.get(4).get(0).equals("deed");
        assert result.get(5).size()==2;
        assert result.get(5).contains("level");
        assert result.get(5).contains("radar");
    }

    @Test
    public void isPalindrome() {
        PalindromProcessor processor = new PalindromProcessor();
        assert !processor.isPalindrome("word");
        assert processor.isPalindrome("asdffdsa");
        assert processor.isPalindrome("asdfgfdsa");
        assert processor.isPalindrome("sssss");
        assert !processor.isPalindrome("sslls");
    }

    @Test
    public void isPalindromeEdgeCases() {
        PalindromProcessor processor = new PalindromProcessor();
        assert !processor.isPalindrome("aa");
        assert !processor.isPalindrome(null);
        assert !processor.isPalindrome("");
    }

    @Test
    public void getLongestPalindromes() throws FileNotFoundException {
        PalindromProcessor processor = new PalindromProcessor(FileUtils.readStrings("testResources/input.txt"));
        processor.processFile();
        List<String> palindromes = processor.getLongestPalindromes();
        assert palindromes.size()==2;
        assert palindromes.contains("level");
        assert palindromes.contains("radar");
    }
}