name := "hiring"

version := "0.1"

scalaVersion := "2.12.8"

scalacOptions += "-Ypartial-unification"

libraryDependencies += "org.typelevel" %% "cats-core" % "1.5.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.7" % Test
