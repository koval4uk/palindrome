package finders;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LinePalindrome implements SubstringFinder {

	@Override
	public Set<String> findSubstring(String inputString) {
		for (int i = 0; i < inputString.length(); i++) {
			char firstChar = inputString.charAt(i);

			for (int j = inputString.length() - 1; j > i; j--) {

			}



		}


		return null;
//		return Arrays.stream(inputString)
//				.filter(word -> {
//					if (word.length() < 3) {
//						return false;
//					}
//					for (int i = 0; i < word.length(); i++) {
//						if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
//							return false;
//						}
//					}
//					return true;
//				})
//				.collect(Collectors.toSet());
//	}
	}
}
