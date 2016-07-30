package project1
trait Line {
  def parseInput(in : java.io.InputStream) : Iterator[String] = {
    /* To break the standard input down into words*/
    scala.io.Source.fromInputStream(in).getLines.map(_.trim).flatMap(_.split("\\W+"))

  }
}/* trait Line*/
class ImmutableLine extends Line {

  def buildMap(words : Iterator[String]) : Map[String, Int] = {
    /* let the first instance to be Null- ""*/
    words.foldLeft(Map("" -> 0)) { (bmap, word) =>
    {
      if(bmap.contains(word)) { bmap ++ Map(word -> (bmap(word) + 1)) - "" }/* if word the same count ++*/
      else { bmap ++ Map(word -> 1) - ""  }
    }  }
  }/*def*/

}/* Immutable Line*/

object WordCount2 extends App{
  println("Hello")
  val immutableLine = new ImmutableLine
  val inFile = new java.io.FileInputStream("input.txt")
  val map = immutableLine.buildMap(immutableLine.parseInput(inFile))
  println(map)
}
/*
Hello
Map(hello -> 3, world -> 2, goodbye -> 1)
 */