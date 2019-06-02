package com.service;

import java.io.IOException;
import java.util.stream.Stream;

public interface TextReaderService {

    Stream<String> readFile(String filename) throws IOException;
}
