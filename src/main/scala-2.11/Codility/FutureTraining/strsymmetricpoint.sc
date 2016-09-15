/*
Write a function:

int solution(char *S);
that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.

Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.

For example, given a string:

"racecar"

the function should return 3, because the substring to the left of the character "e" at index 3 is "rac", and the one to the right is "car".

Given a string:

"x"

the function should return 0, because both substrings are empty.

Assume that:

the length of S is within the range [0..2,000,000].
Complexity:

expected worst-case time complexity is O(length(S));
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */
val s ="racecar"
val mid = s.length/2
s take mid
s takeRight  mid
solution("racecar")
solution("x")
solution("carerac")
def solution(s:String):Int={

  val n = s.length

  n match {
    case 1 => 0
    case x if x%2==0 => -1
    case y if y%2 != 0 => {

      val mid = y/2
      val left = s take mid
      val right = s takeRight  mid
      if(left.reverse == right)left.length else -1
    }
    case _ => 0
  }

}

//100 %
//https://codility.com/demo/results/trainingQSUGH8-WX9/
