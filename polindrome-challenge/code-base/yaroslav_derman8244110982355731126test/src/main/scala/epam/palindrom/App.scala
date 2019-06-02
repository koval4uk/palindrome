package epam.palindrom

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

import cats.syntax.either._
import cats.syntax.try_

import scala.io.BufferedSource
import scala.io.BufferedSource
import scala.io.Source
import scala.util.Try

object PalindromApp {

  type Error = String

  def main(args: Array[String]): Unit = {
    for {
      inputFileName <- readArg[String](args, 0, "input file name not defined")
      outputFileName <- readArg[String](args, 1, "output file name not defined")
      source <- readFile(inputFileName)
      palindromes <- findPalindromes(source)
      _ <- writeToFile(outputFileName, palindromes.toSeq)
    } yield {
      println(s"you can find result in $outputFileName")
    }
  }

  def readArg[T](args: Array[String],
                 index: Int,
                 error: => String): Either[Error, T] = {
    Either
      .fromTry(Try(args(index).asInstanceOf[T]))
      .leftMap(_ => error)
      .map { el =>
        println(s"Read arguments $index")
        el
      }
  }

  def isPalindrome(el: String): Boolean = {
    if (el.lengthCompare(1) == 0) {
      true
    } else if (el.isEmpty) {
      false
    } else {
      el == el.reverse
    }
  }

  def readFile(filePath: String): Either[String, BufferedSource] = {
    Either
      .fromTry(Try(Source.fromFile(filePath)))
      .leftMap { error =>
        s"cant read from file $filePath"
      }
  }

  def findPalindromes(source: BufferedSource) = {
    val lines = source.getLines()

    (for {
      line <- lines
      word <- line.split("""[\s,;.!]+""") if isPalindrome(word)
    } yield {
      word
    }).asRight[Error]

  }

  def writeToFile(fileName: String, palindroms: Seq[String]) = {
    for {
      file <- Either.fromTry(Try(new File(fileName))).leftMap { _ =>
        s"can't create output file $fileName"
      }
      bw <- Either
        .fromTry(Try(new BufferedWriter(new FileWriter(file))))
        .leftMap { _ =>
          "can't create bufferd writer "
        }
    } yield {
      palindroms.sorted(Ordering[String].reverse).foreach { word =>
        bw.write(word)
        bw.write("\n")
      }
      bw.close()
    }

  }

}
