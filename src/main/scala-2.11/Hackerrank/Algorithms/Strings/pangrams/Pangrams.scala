package Hackerrank.Algorithms.strings.pangrams

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
/*
Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence , tell Roy if it is a pangram or not.

Input Format

Input consists of a string .

Constraints
Length of  can be at most   and it may contain spaces, lower case and upper case letters. Lower-case and upper-case instances of a letter are considered the same.

Output Format

Output a line containing pangram if  is a pangram, otherwise output not pangram.

Sample Input

Input #1

We promptly judged antique ivory buckles for the next prize
Input #2

We promptly judged antique ivory buckles for the prize
Sample Output

Output #1

pangram
Output #2

not pangram
 */