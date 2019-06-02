package com.epam.hiring.util;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @author Sergiy Dyrda created on 01.06.2019
 */
@Data
public class CommandOptions {
    private String inputFilePath;
    private String outFilePath;
    private Set<Flag> flags;

    public CommandOptions(String[] args) {
        init(args);
    }

    private void init(String[] args) {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("At least to arguments must be set!");
        }
        inputFilePath = args[0];
        outFilePath = args[1];
        if (args.length > 2) {
            flags = new HashSet<>();
            for (int i = 2; i < args.length - 1; i++) {
                try {
                    Flag flag = Flag.valueOf(args[i]);
                    flags.add(flag);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Incorrect flag name " + args[i] + ". Permitted flags are: "
                            + Flag.stringRepresentation());
                }
            }
        }
    }

    public enum Flag {
        parallel,
        line;

        static String stringRepresentation() {
            StringJoiner joiner = new StringJoiner(", ");
            for (Flag val : values()) {
                joiner.add(val.name());
            }
            return joiner.toString();
        }
    }

}


