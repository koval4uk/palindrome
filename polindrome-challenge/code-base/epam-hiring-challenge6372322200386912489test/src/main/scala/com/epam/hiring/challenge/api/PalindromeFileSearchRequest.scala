package com.epam.hiring.challenge.api

import java.io.File

/**
  * Model representing palindrome search request
  *
  * @param inputFile input file to search palindromes in
  * @param outputFile output file to write found palindromes out
  * @param parallel flag to indicate allow use multiple threads
  * @param line flag to indicate
  */
case class PalindromeFileSearchRequest(inputFile: File, outputFile: File, parallel: Boolean, line: Boolean)
