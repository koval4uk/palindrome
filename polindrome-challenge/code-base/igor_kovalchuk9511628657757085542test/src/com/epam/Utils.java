package com.epam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Utils {

	public static String[] loadFileIntoArray(String filePath) throws IOException {
		ArrayList<String> result = new ArrayList<>();

		BufferedReader br = Files.newBufferedReader(Paths.get(filePath));

		String line;
		while ((line = br.readLine()) != null) {
			result.add(line);
		}

		String[] s = {};
		return result.toArray(s);
	}

	public static String loadFile(String filePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = Files.newBufferedReader(Paths.get(filePath));

		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line).append("\n");
		}

		return sb.toString();
	}

	public static void saveFile(String filePath, String[] data) throws FileNotFoundException, IOException {
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
		for (String s : data) {
			writer.write(s);
			writer.write("\n");
		}
		writer.close();
	}

	public static String reverse(String s) {
		if (s.trim().length() == 0) {
			return "";
		}
		char[] chars = s.toCharArray();
		char[] result = new char[chars.length];
		int j = 0;
		for(int i = chars.length -1; i >= 0; i--) {
			result[j] = chars[i];
			j++;
		}
		return new String(result);
	}
}
