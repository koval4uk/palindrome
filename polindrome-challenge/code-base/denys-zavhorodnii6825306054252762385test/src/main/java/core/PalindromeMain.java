package core;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import core.exceptions.NotEnoughParams;
import finders.WordPalindrome;
import finders.SubstringFinder;
import reports.Destination;
import reports.DestinationException;
import reports.FileDestination;
import sources.FileSource;
import sources.Source;

public class PalindromeMain {


	public static void main(String[] args) throws NotEnoughParams, DestinationException {
		ConsoleParams params = readConsoleParams(args);

		Source source = new FileSource();
		List<String> inputData = source.readData(params);

		SubstringFinder finder = new WordPalindrome();
		Set<String> resultList = inputData.stream()
				.map(finder::findSubstring)
				.flatMap(Collection::stream)
				.collect(Collectors.toSet());
		Destination destination = new FileDestination();
		destination.saveData(getMaxSortedLines(resultList), params);

	}

	private static List<String> getMaxSortedLines(Set<String> resultList){
		Optional<Integer> maxLength = resultList.stream()
				.map(String::length)
				.max(Integer::compareTo);
			return resultList.stream()
					.filter(s -> s.length() == maxLength.get())
					.sorted()
					.collect(Collectors.toList());
	}

	private static ConsoleParams readConsoleParams(String[] args) throws NotEnoughParams {
		ConsoleParams params = new ConsoleParams();
		if( args.length < 2) {
			throw new NotEnoughParams();
		}
		params.setInputFileName(args[0]);
		params.setResultFileName(args[1]);
		return params;
	}


}
