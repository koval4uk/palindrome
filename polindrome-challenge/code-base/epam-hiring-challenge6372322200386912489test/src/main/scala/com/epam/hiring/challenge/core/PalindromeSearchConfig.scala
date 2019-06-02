package com.epam.hiring.challenge.core

import scala.concurrent.ExecutionContext

/**
  * Model representing additional configuration or context of palindrome search
  *
  * @param line flag indicating search lines or words
  * @param parallel either parallel or not
  */
case class PalindromeSearchConfig(line: Boolean, parallel: Boolean)
