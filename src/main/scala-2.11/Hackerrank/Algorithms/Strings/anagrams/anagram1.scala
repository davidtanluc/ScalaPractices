package Hackerrank.Algorithms.strings.anagrams


/**
  * Created by davidtan on 9/25/16.
  */
object anagram1 {
  import scala.collection.mutable

  def makeAnagram(word: Words) = {
    val occ = mutable.Map[Char, Int]()
    for (el <- word) if (occ.isDefinedAt(el)) occ(el) += 1 else occ(el) = 1
    occ
  }

  type Words = String
  def solution(str: Words): Int = {
    val N = str.length
    if (N % 2 != 0) return -1 //odd out!
    val n = N / 2
    val (fst, snd) = str splitAt n
    val left =  makeAnagram(fst) //O(N/2)
    val right = makeAnagram(snd)
    var count = 0
    val all = left ++ right

    for (el <- all.keys)
      if (right.isDefinedAt(el)) count += Math.abs(right(el) - left.getOrElse(el, 0))
                            else count += left(el)

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

/*
//https://www.hackerrank.com/challenges/anagram

/*
Sid is obsessed with reading short stories. Being a CS student, he is doing some interesting frequency analysis with the books.
He chooses strings  and  in such a way that .

Your task is to help him find the minimum number of characters of the first string he needs to change to enable him to
make it an anagram of the second string.

Note: A word x is an anagram of another word y if we can produce y by rearranging the letters of x.

Input Format
The first line will contain an integer, , representing the number of test cases. Each test case will contain a string having length ,
 which will be concatenation of both the strings described above in the problem.The given string will contain only characters from  to .

Output Format
An integer corresponding to each test case is printed in a different line, i.e. the number of changes required for each test case.
 Print  if it is not possible.

Constraints


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
---------------------
Explanation
Test Case #01: We have to replace all three characters from the first string to make both of strings anagram.
Here,  = "aaa" and  = "bbb". So the solution is to replace all character 'a' in string a with character 'b'.

Test Case #02: You have to replace 'a' with 'b', which will generate "bb".

Test Case #03: It is not possible for two strings of unequal length to be anagram for each other.

Test Case #04: We have to replace both the characters of first string ("mn") to make it anagram of other one.

Test Case #05:  and  are already anagram to each other.

Test Case #06: Here S1 = "xaxb" and S2 = "bbxx". He had to replace 'a' from S1 with 'b' so that S1 = "xbxb"
and we can rearrange its letter to "bbxx" in order to get S2.
 */
 */