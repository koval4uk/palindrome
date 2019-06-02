package com.epam;

public class Main {

	public static void main(String[] args) {
		if (args.length < 2) {
			errorMessage();
			System.exit(1);
		}

		String filePath = args[0];
		String outputFilePath = args[1];

		try {
			String text = Utils.loadFile(filePath);
			String[] result = PalindromLookup.start(text);
			Utils.saveFile(outputFilePath, result);
		} catch (Throwable t) {
			System.err.println("Error: " + t.getMessage());
			System.exit(1);
		}
	}

	static void errorMessage() {
		System.err.println("Please specify parameters: \"input.txt\" \"result.txt\" [ parallel ] [ line ]");
	}
}
