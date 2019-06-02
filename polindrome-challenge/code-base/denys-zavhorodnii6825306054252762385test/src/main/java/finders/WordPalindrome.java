package finders;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WordPalindrome implements SubstringFinder {
	public Set<String> findSubstring(String inputString) {

		String[] splitedLine = inputString.replace("  ", "").split(" ");
		return Arrays.stream(splitedLine)
				.filter(word -> {
					if (word.length() < 3) {
						return false;
					}
					for (int i = 0; i < word.length(); i++) {
						if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
							return false;
						}
					}
					return true;
				})
				.collect(Collectors.toSet());
	}
}
