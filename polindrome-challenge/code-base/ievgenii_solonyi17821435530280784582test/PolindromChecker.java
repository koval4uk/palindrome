package polindroms_checkers.polindrom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class PolindromChecker {

	public static String reverse(String string) {
		return Stream.of(string).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
	}

	public static void main(String[] args) throws IOException {

		System.out.print("Enter filename: ");
		try (final Stream<String> lines = Files.lines(Paths.get(new Scanner(args[0]).nextLine()))
				.map(line -> line.split("[\\s]+")).flatMap(Arrays::stream).distinct().sorted()) {
			final String uniqueWords = lines.collect(joining(", "));
			String[] arrOfStr = uniqueWords.split(",");
			for (String wordToCheck : arrOfStr) {
				String clearWord = wordToCheck.trim().toLowerCase().replaceAll("[^A-z^a-z^-^А-Я^а-я^ ^І^і^Є^є^ї^Ї]",
						"");
				System.out.println("clearword:" + clearWord);
				if (!clearWord.equals("")) {
					if (clearWord.length() > 2) {
						if (clearWord.equals(reverse(clearWord))) {
							System.out.println("polindrom: " + clearWord);
							String wordToOutput = clearWord + " ";
							try {
								Files.write(Paths.get(args[1]), wordToOutput.getBytes(),
										StandardOpenOption.APPEND);
							} catch (IOException e) {
								// exception handling left as an exercise for the reader
							}
						}
					}
				}
			}
		}

	}

}
