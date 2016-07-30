package project1
import org.scalatest.FunSuite
/* This the imperative Test version of the wordcount */
class WordCountTest extends FunSuite {

  val wordMap = scala.collection.mutable.Map[String,Int]()

  test("A test two words equals") {
    assert("hello".equals("hello"))
  }
  test("A test map") {
    wordMap+="hello"->1
    assert("Map(hello -> 1)".equals(wordMap.toString()))
  }





}/*WordCountTest*/
