package project1

import org.scalatest.FunSuite
/* This the functional test version of the wordcount */
class WordCountFunctionalTest extends FunSuite {

  val expectedWords = List("hello","hello","world", "goodbye","hello","world")
  val immutableLine = new ImmutableLine

  test("Checks whether builds map correctly") {
  val inFile = new java.io.FileInputStream("input.txt")
  val map = immutableLine.buildMap(immutableLine.parseInput(inFile))

    assert(3 == map.size)
    assert(3 == map("hello"))
    assert(2 == map("world"))
    assert(1 == map("goodbye"))
  }

}
