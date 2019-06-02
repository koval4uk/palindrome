package com.epam.hiring.challenge

import java.io.File

import com.epam.hiring.challenge.api.PalindromeFileSearchRequest
import com.epam.hiring.challenge.core.PalindromeFileSearcher

object App {
  def main(args: Array[String]): Unit = {
    val inputFileNameArgument = args.toList.lift(0).getOrElse {
      println("Please, specify input file path argument")
      sys exit 1
    }

    val resultFileNameArgument = args.toList.lift(1).getOrElse {
      println("Please, specify input file path argument")
      sys exit 1
    }

    val parallelArgument = args.toList.lift(2).exists(_.toBoolean)
    val lineArgument = args.toList.lift(3).exists(_.toBoolean)

    val inputFile = new File(inputFileNameArgument)
    val outputFile = new File(resultFileNameArgument)
    val request = PalindromeFileSearchRequest(inputFile: File, outputFile: File, parallelArgument, lineArgument)
    val resultPath = PalindromeFileSearcher.search(request)

    println(s"Palindromes written to output file successfully. Result file located at: $resultPath")
  }
}
