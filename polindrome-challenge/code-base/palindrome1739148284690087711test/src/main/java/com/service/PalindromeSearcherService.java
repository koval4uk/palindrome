package com.service;

import java.util.List;
import java.util.stream.Stream;

public interface PalindromeSearcherService {

    List<String> find(Stream<String> line);
    List<String> findLongest(List<String> palindromes);
}
