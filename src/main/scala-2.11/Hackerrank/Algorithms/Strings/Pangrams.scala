package Hackerrank.Algorithms.strings

//https://www.hackerrank.com/challenges/pangrams
object Solution {

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    def helper(str: String): String = {
      var joinString = ""
      str.split("\\s+").
        foreach(x => joinString += x.toLowerCase())

      val map1 = joinString.mkString(",")

        .map(x => (x, 1)).groupBy(_._1).

        map(x => (x._1, x._2.length)).

        toSeq.

        sorted

        .size
      //println("SIZE  "+map1)
      if (map1 == 26+1) return "pangram"
      "not pangram"
    }

    val str= scala.io.StdIn.readLine()
    //println(str)
    println(helper(str))
    //helper(str)
  }
}