package by.yauheniy.lepkovich;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class PolindormChecker {

    private FileUtil fileUtil = FileUtil.getInstance();

    public static void main(String[] args) {
        checkArgs(args);
        String inputTextFilePath = args[0];
        String outputTextFilePath = args[1];

        String text = FileUtil.readText(inputTextFilePath);
        List<String> polidroms = PolidromUtil.toPolidroms(text);
        List<String> mostLengthPolidroms = PolidromUtil.toMostLongerPolindrom(polidroms);
        FileUtil.writePolidroms(outputTextFilePath, mostLengthPolidroms);
    }

    private static void checkArgs(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("not enough args to execute");
        }
        if (StringUtils.isEmpty(args[0])) {
            throw new IllegalArgumentException("input filepath should not be empty");
        }
        if (StringUtils.isEmpty(args[1])) {
            throw new IllegalArgumentException("output filepath should not be empty");
        }
    }
}
