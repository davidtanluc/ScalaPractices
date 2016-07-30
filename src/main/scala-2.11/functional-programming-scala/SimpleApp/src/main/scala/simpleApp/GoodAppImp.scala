package simpleApp

object GoodAppImp extends App {
  val lines = scala.io.Source.fromFile("someFile.txt").getLines
  var count =0
  lines foreach {line =>
    println(line)
    count += 1
  }
  println(count + "lines counted")
}

/* val lines = scala.io.Source.fromInputStream(System.in).getLines*/
/*
first line
second line
third line
3lines counted

 */