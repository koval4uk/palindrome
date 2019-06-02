package com.epam;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PalindromLookup {

	/** 
	 * Palindoms lookup.
	 * 
	 * Limitations: it doesn't ignore "!" and other special symbols.
	 *  
	 * @param text
	 * @return an array of palindroms of maximum length.
	 */
	public static String[] start(String text) {
		
		// Using a slow split; alternatives: Guava Splitter - https://softwareengineering.stackexchange.com/a/222000

		ArrayList<String> result = new ArrayList<>();
		
		String[] values = text.split("[\\s\\r\\n]");

		List<String> direct = new ArrayList<>();
		List<String> opposite = new ArrayList<>();

		// to implement the "line" mode
		List<Integer> directPosition = new ArrayList<>();
		List<Integer> oppositePosition = new ArrayList<>();

		Map<String, Integer> words = new HashMap<>();
		Set<String> found = new HashSet<>();

		int pos = 0;
		for (String s : values) {
			System.out.println(s);
			direct.add(s);
			opposite.add(Utils.reverse(s));
			words.put(s, pos);
			pos++;
		}

		pos = 0;
		int max = 0;
		for (String o : opposite) {
			if (words.containsKey(o)) {
				found.add(direct.get(pos));
				if (o.length() > max) {
					max = o.length();
					//System.out.println(max);
				}
			}
		}

		for(String s : found) {
			if (s.length() == max) {
				result.add(s);
			}
		}

		// TODO: has errors - need more time to debug;
		
		String[] s = {};
		return result.toArray(s);
	}

}
