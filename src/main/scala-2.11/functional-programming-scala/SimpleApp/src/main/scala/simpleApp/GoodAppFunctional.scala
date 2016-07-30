package simpleApp

/**
 * Created by David on 3/7/14.
 */
object GoodAppFunctional extends App {
  val lines = scala.io.Source.fromFile("someFile.txt").getLines
  var count =lines.foldLeft{
    0
  }{ (c,line)=>
    println(line +" " +c)
    c+1
  }
  println(count + "lines counted")

}
/* val lines = scala.io.source.fromInputStream(System.in).getLines*/
/*Output
first line 0
second line 1
third line 2
3lines counted
 */