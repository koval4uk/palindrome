package com.epam.hiring.challenge.core

/**
  * Type-level wrapper around plain string guarantees that it's value non-empty
 *
  * @param value non empty string
  */
case class NonEmptyString(value: String)

object NonEmptyString {

  def apply(value: String): Option[NonEmptyString] = {
    if(value.nonEmpty) Some(new NonEmptyString(value)) else None
  }
}
