package simpleApp

/**
 * Created by David on 3/7/14.
 */
object BadApp extends App {
  val lines = scala.io.Source.fromFile("someFile.txt").getLines.toList
  lines foreach { println(_)}
 // println(lines.count + " lines counted ")
  println(lines + " lines counted ")
}

/*val lines = scala.io.Source.fromInputStream(System.in).getLines.toList*/
/*
first line
second line
third line
List(first line, second line, third line) lines counted

 */