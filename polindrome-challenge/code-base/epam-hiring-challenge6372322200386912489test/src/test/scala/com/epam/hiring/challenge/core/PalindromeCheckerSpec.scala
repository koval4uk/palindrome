package com.epam.hiring.challenge.core

import org.scalatest.{FlatSpec, FreeSpec, Matchers, WordSpec}

class PalindromeCheckerSpec extends WordSpec with Matchers {

  s"$PalindromeChecker" when {
    "receives 1 character length string" should {
      "return 'true'" in {
        PalindromeChecker.isPalindrome(NonEmptyString("1").get) shouldBe true
      }
    }

    "palindrome 2 characters length string" should {
      "return 'true'" in {
        PalindromeChecker.isPalindrome(NonEmptyString("11").get) shouldBe true
      }
    }

    "NOT palindrome 2 characters length string" should {
      "return 'false'" in {
        PalindromeChecker.isPalindrome(NonEmptyString("12").get) shouldBe false
      }
    }

    "palindrome 3 characters length string" should {
      "return 'true'" in {
        PalindromeChecker.isPalindrome(NonEmptyString("212").get) shouldBe true
      }
    }

    "NOT palindrome 3 characters length string" should {
      "return 'true'" in {
        PalindromeChecker.isPalindrome(NonEmptyString("213").get) shouldBe false
      }
    }

    "palindrome long length string" should {
      "return 'true'" in {
        PalindromeChecker.isPalindrome(NonEmptyString("radar").get) shouldBe true
      }
    }

    "NOT palindrome long length string" should {
      "return 'true'" in {
        PalindromeChecker.isPalindrome(NonEmptyString("abcdefgk").get) shouldBe false
      }
    }
  }
}
