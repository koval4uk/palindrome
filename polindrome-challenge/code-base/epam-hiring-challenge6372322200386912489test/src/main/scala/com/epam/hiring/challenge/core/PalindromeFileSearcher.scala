package com.epam.hiring.challenge.core

import java.nio.charset.Charset
import java.nio.file.{Files, Path}

import com.epam.hiring.challenge.api.PalindromeFileSearchRequest

import scala.collection.JavaConverters._
import scala.io.Source

object PalindromeFileSearcher {

  def search(request: PalindromeFileSearchRequest): Path = {
    implicit val config: PalindromeSearchConfig = PalindromeSearchConfig(request.line, request.parallel)
    val source = Source.fromFile(request.inputFile)
    val result = PalindromeSearcher.search(source)

    Files.write(request.outputFile.toPath, result.asJava, Charset.defaultCharset())
  }
}
