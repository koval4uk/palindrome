package com.epam.hiring.service;

import java.util.Set;

/**
 * @author Sergiy Dyrda created on 01.06.2019
 */
public interface PalindromeService {

    Set<String> findLongestPalindromes(String item, boolean caseSensitive);

    Set<String> findLongestPalindromes(String item, boolean caseSensitive, String[] splitters);

}
