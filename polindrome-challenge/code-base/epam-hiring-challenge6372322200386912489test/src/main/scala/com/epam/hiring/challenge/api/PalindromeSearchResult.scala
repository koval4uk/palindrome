package com.epam.hiring.challenge.api

/**
  * Model representing palindrome search result
  *
  * @param palindromes found palindromes with max length
  */
case class PalindromeSearchResult(palindromes: Set[String])
