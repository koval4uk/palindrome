package com.epam.hiring.challenge.core

/**
  * Class that provides basic capabilities to check if string is palindrome or not
  */
object PalindromeChecker {
  /**
    * Checks whether incoming string is palindrome or not
    * @param nes string
    * @return
    */
  def isPalindrome(nes: NonEmptyString): Boolean = {
    val value = nes.value
    val length = value.length

    length match {
      case 1 => true
      case 2 => value(0) == value(1)
      case _ =>
        val half = length.toDouble / 2
        val floor = Math.floor(half).toInt
        val ceil = Math.ceil(half).toInt
        value.slice(0, floor) == value.slice(ceil, length).reverse
    }
  }
}
