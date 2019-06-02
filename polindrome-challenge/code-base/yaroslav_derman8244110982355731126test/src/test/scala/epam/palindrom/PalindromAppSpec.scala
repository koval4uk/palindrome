package epam.palindrom

import org.scalatest.MustMatchers
import org.scalatest.WordSpec

class PalindromAppSpec extends WordSpec with MustMatchers {

  "PalindromAppSpec" should {

    "fail to read from undefined args" in {
      val error = "undefined element"
      PalindromApp.readArg(Array.empty[String], 1, error) mustBe Left(error)
    }

    "read zero element from args" in {
      val element = "element"

      PalindromApp.readArg(Array(element), 0, "undefined element") mustBe Right(
        element
      )
    }

    "read file successfull" in {
      val fileName = "input.txt"
      PalindromApp.readFile(fileName).isRight mustBe true
    }

    "not read file" in {
      val fileName = "input2.txt"
      PalindromApp.readFile(fileName).isLeft mustBe true
    }

  }

}
