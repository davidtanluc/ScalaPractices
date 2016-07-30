package simpleApp

object CountLines extends App {
  import System._
  //val src = scala.io.Source.fromFile("someFile.txt")
  //val count = src.getLines().map(x => 1).sum
  val lines = scala.io.Source.fromFile("someFile.txt").getLines()

  var count =lines.foldRight(0){(line,c)=>
    println(line +" " +c)
    c+1
  }
  println(count + " lines counted")

  /* 2#*/
  val lines2 = scala.io.Source.fromFile("someFile.txt").getLines()
  val count2 = lines2.map(x => 1).sum
  println(count2 +" count2 "  )
}
/* Ans
third line 0
second line 1
first line 2
3 lines counted
3 count2
 */