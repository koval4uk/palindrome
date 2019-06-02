package palindrom.main;

import palindrom.utils.FileUtils;
import palindrom.services.PalindromProcessor;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        assert args.length>=2;
        PalindromProcessor processor = new PalindromProcessor(FileUtils.readStrings(args[0]));
        if(args.length>=3 && args[2].equals("parallel")) processor.setParallel(true);
        processor.processFile();
        List<String> result = processor.getLongestPalindromes();
        result.sort(Comparator.naturalOrder());
        FileUtils.writeToFile(String.join("\n", result), args[1]);
    }
}
