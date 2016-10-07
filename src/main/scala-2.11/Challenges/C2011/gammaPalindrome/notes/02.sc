def longestPalindromicSubstring(s: String, p: List[Int], i: Int): String = {
  val length = p(i + 2)
  val center = i + 2
  s.substring((center - 1 - length) / 2, (center - 1 + length) / 2)
}

def positions(str: String): List[Int] = {

  val t = "$" + (for (ch <- str) yield "#" + ch).toList.mkString("") + "#@"
  val p = new Array[Int](t.length) // palindrome position
  var center = 0
  var right = 0

  for (i <- 1 until t.length - 1) {
    val mirror = 2 * center - i

    if (right > i) p(i) = (right - i) min p(mirror)

    // attempt to expand palindrome centered at i
    while (t(i + (1 + p(i))) == t(i - (1 + p(i)))) p(i) += 1
    //println("right:", right, "i:", i, " ", p.toList)
    /*
(right:,0,i:,1, ,List(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,1,i:,2, ,List(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,3,i:,3, ,List(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,3,i:,4, ,List(0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,5,i:,5, ,List(0, 0, 1, 0, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,9,i:,6, ,List(0, 0, 1, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,9,i:,7, ,List(0, 0, 1, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,9,i:,8, ,List(0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,11,i:,9, ,List(0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0))
(right:,11,i:,10, ,List(0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 5, 0, 0, 0, 0, 0, 0))
(right:,15,i:,11, ,List(0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 5, 0, 0, 0, 0, 0, 0))
(right:,15,i:,12, ,List(0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 5, 0, 3, 0, 0, 0, 0))
(right:,15,i:,13, ,List(0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 5, 0, 3, 0, 0, 0, 0))
(right:,15,i:,14, ,List(0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 5, 0, 3, 0, 1, 0, 0))
(right:,15,i:,15, ,List(0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 5, 0, 3, 0, 1, 0, 0)
     */

    // if palindrome centered at i expands past right,
    // adjust center based on expanded palindrome.
    if (i + p(i) > right) {
      center = i
      right = i + p(i)
    }

  } //for
  p.toList
}
def solution(str: String) = {
  val pos = positions(str)

  for (i <- 0 until 2 * str.length) {
    println(i + ": " + longestPalindromicSubstring(str, pos, i))
  }
}
solution("baababa") //6
/*
0: b
1:
2: a
3: baab
4: a
5:
6: aba
7:
8: ababa
9:
10: aba
11:
12: a
13:
 */