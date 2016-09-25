package Hackerrank.Algorithms.strings.anagrams

/**
  * Created by davidtan on 9/25/16.
  */
object anagram2 {
  type Words = String
  //solution("aaabbb") //3
 // solution("xaxbbbxx") //1
  def solution(str: Words): Int = {
    val N = str.length
    if (N % 2 != 0) return -1 //odd out!
    val n = N / 2

    val (fst, snd) = str splitAt n
    //println(fst,snd)//(xaxb,bbxx)
    var count = 0
    val firstCount = Array.fill(26)(0)
    val secondCount = Array.fill(26)(0)

    for (el <- fst) firstCount(el - 'a') += 1
    // println(firstCount.toList)
    //List(1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0)
    for (el <- snd) secondCount(el - 'a') += 1
    //println(secondCount.toList)
    //List(0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0)
    for (i <- 0 until 26) count += Math.abs(firstCount(i) - secondCount(i))
    //println(count) //2
    count / 2

  }

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val t = sc.nextInt()
    val tasks = (for(i <- 0 until t) yield sc.next()).toList
    tasks.foreach(token =>println(solution(token)))

  }
}
/*
Sample Input

6
aaabbb
ab
abc
mnop
xyyx
xaxbbbxx
Sample Output

3
1
-1
2
0
1
 */