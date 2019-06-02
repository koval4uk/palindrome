package com.epam.hiring.challenge.core

import scala.collection.GenSeq
import scala.io.Source

object PalindromeSearcher {
  /**
    *
    * @param request
    * @param config
    */
  def search(request: Source)(implicit config: PalindromeSearchConfig): Seq[String] = {
    val lines = request.getLines().toArray

    val input: GenSeq[String] = if(config.parallel) lines.par else lines.toSeq

    val allPalindromes = input.par
      .map(_.toLowerCase)
      .flatMap(_.split(" "))
      .map(_.trim)
      .flatMap(NonEmptyString.apply)
      .filter(PalindromeChecker.isPalindrome)
      .map(_.value)

    val result = if (allPalindromes.nonEmpty) {
      val maxLength = allPalindromes.map(_.length).max
      allPalindromes.filter(_.length == maxLength)
    } else {
      allPalindromes
    }

    result.toList
  }
}
