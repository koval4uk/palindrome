package com.github.kovalchuk;

import org.apache.log4j.Logger;

import java.util.StringJoiner;

public class App {
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        RequestDTO requestDTO = new RequestDTO();
        if (args.length == 2) {
            requestDTO.setInputFile(args[0]);
            requestDTO.setOutputFile(args[1]);
        } else {
            logger.error("Invalid input params. Need input: [java -jar Palindrom.jar \"input.txt\" \"result.txt\"]");
        }

        logger.info("Hello World! " + requestDTO.toString());
    }

    static class RequestDTO {
        String inputFile;
        String outputFile;

        public String getInputFile() {
            return inputFile;
        }

        public void setInputFile(String inputFile) {
            this.inputFile = inputFile;
        }

        public String getOutputFile() {
            return outputFile;
        }

        public void setOutputFile(String outputFile) {
            this.outputFile = outputFile;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", RequestDTO.class.getSimpleName() + "[", "]")
                .add("inputFile='" + inputFile + "'")
                .add("outputFile='" + outputFile + "'")
                .toString();
        }
    }
}
