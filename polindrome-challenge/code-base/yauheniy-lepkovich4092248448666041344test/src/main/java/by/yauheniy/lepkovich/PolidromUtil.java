package by.yauheniy.lepkovich;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PolidromUtil {

    private static final Predicate<String> isPolidrom = text ->
            text.replaceAll("\\W","")
                    .equalsIgnoreCase(new StringBuilder(text.replaceAll("\\W",""))
                            .reverse().toString());

    public static List<String> toPolidroms(String text) {
        return Arrays.asList(text.split(" ")).stream()
                .filter(isPolidrom)
                .collect(Collectors.toList());
    }


    public static List<String> toMostLongerPolindrom(List<String> polidroms) {
        Integer maxLength = polidroms.stream().max(Comparator.comparingInt(String::length)).get().length();
        return polidroms.stream().filter(polidrom -> polidrom.length() == maxLength).sorted().collect(Collectors.toList());
    }
}
