package project1
/* This the functional version of the wordcount */
trait Line2 {

  def parseInput(in : java.io.InputStream) : Iterator[String] = {
    /* To break the standard input down into words*/
    scala.io.Source.fromInputStream(in).getLines.map(_.trim).flatMap(_.split("\\W+"))
  }
}/* trait Line*/
/* read the codes from file */
class ImmutableLine2 extends Line2 {

  def buildMap(words : Iterator[String]) : Map[String, Int] = {
    words.foldLeft(Map.empty[String, Int]){/* immutable*/
      (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
  }/*def*/
  }

}/* Immutable Line*/

object WordCountFunctional extends App {
  println("Hello")
  val immutableLine2 = new ImmutableLine2
  //val inFile = new java.io.FileInputStream("input.txt")
  val inFile = new java.io.FileInputStream("input1.txt")
  val map = immutableLine2.buildMap(immutableLine2.parseInput(inFile))
  println(map)
}

/*
Hello
Map(number -> 1, for -> 2, trend -> 1, are -> 1, labor -> 1, show -> 1, market -> 1, four -> 1,
 smoothes -> 1, increasing -> 1, insurance -> 1, volatility -> 1, unemployment -> 2, a -> 1, moving -> 1, An -> 1,
 out -> 1, to -> 1, individuals -> 1, week -> 1, The -> 1, who -> 1, new -> 1, deteriorating -> 1, first -> 1,
 claims -> 2, compiled -> 1, suggests -> 1, time -> 1, average -> 1, New -> 1, decreasing -> 1, weekly -> 2,
 filed -> 1, of -> 2, improving -> 1, the -> 2)
 */