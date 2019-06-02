package ua.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	enum Type {
		LINE, WORD
	}

	public static void main(final String[] args) throws IOException {
		if (args.length < 2) {
			throw new IllegalArgumentException("There should be at least 2 arguments");
		}

		final String inputFilePath = args[0];
		final String outputFilePath = args[1];

		final List<String> strings = Files.readAllLines(Paths.get(inputFilePath));

		final Path path = Paths.get(outputFilePath);
		if (Files.deleteIfExists(path)) {
			Files.createFile(path);
		}

		final Type type = Arrays.asList(args).contains("line") ? Type.LINE : Type.WORD;

		final List<String> result = Arrays.asList(args).contains("parallel") ? parallel(strings, type) : sequential(strings, type)
				.stream()
				.sorted()
				.collect(Collectors.toList());
		Files.write(path, result);
	}

	private static List<String> parallel(final List<String> lines, final Type type) {
		return findPalindromes(lines.parallelStream(), type);
	}

	private static List<String> sequential(final List<String> lines, final Type type) {
		return findPalindromes(lines.stream(), type);
	}

	private static List<String> findPalindromes(final Stream<String> stream, final Type type) {
		return Main.linePalindromes.apply(stream, type);
	}

	private static final BiFunction<Stream<String>, Type, List<String>> linePalindromes = (stream, type) -> {
		if (type == Type.LINE) {
			return getPalindromesSubstrings(stream);
		} else if (type == Type.WORD) {
			return getPalindromes(stream);
		} else {
			throw new IllegalArgumentException("Unknown type " + type);
		}
	};

	private static List<String> getPalindromesSubstrings(final Stream<String> stringStream) {
		return stringStream
				.map(line -> line.replaceAll(" ", ""))
				.map(Main::isPalindromeSubstring)
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(String::length))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue)
				.orElse(Collections.emptyList());
	}

	private static List<String> getPalindromes(final Stream<String> stringStream) {
		return stringStream
				.map(line -> Arrays.stream(line.split(" ")).filter(Main::isPalindromeWord).collect(Collectors.toList()))
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(String::length))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue)
				.orElse(Collections.emptyList());
	}

	private static boolean isPalindromeWord(final String word) {
		final int length = word.length();
		return IntStream.range(0, length / 2)
				.allMatch(i -> Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(word.charAt(length - 1 - i)));
	}

	private static List<String> isPalindromeSubstring(final String line) {
		final int length = line.length();
		return IntStream.range(0, length)
				.mapToObj(i -> findSubstring(line, i))
				.collect(Collectors.toList());
	}

	private static String findSubstring(final String line, final int index) {
		if (line.length() % 2 == 0) {
			return getPalindromeSubstring(line, index, index);
		} else {
			return getPalindromeSubstring(line, index, index + 1);
		}
	}

	private static String getPalindromeSubstring(final String str, int head, int tail) {
		if (head > tail) {
			return null;
		}
		while (head >= 0 && tail < str.length() && str.charAt(head) == str.charAt(tail)) {
			head--;
			tail++;
		}
		return str.substring(head + 1, tail);
	}

}
