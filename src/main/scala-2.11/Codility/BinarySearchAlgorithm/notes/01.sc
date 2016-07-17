/*
14.4. Exercise
Problem:

You are given n binary values x0, x1, . . . , xn−1, such that xi ∈ {0, 1}. This array
represents holes in a roof (1 is a hole). You are also given k boards of the same size. The goal
is to choose the optimal (minimal) size of the boards that allows all the holes to be covered
by boards.


Solution: The size of the boards can be found with a binary search. If size x is sufficient to
cover all the holes, then we know that sizes x+ 1, x+ 2, . . . , n are also sufficient. On the other
hand, if we know that x is not sufficient to cover all the holes, then sizes x − 1, x − 2, . . . , 1
are also insufficient.
 */


val A = Array(0,1,0,0,1,0,1)
val K = 2
solution(A,K)//3
def solution(A: Array[Int], K: Int): Int = {
  val n = A.length
  var beg = 1
  var end = n
  var mid = 0
  var result = -1
  while (beg <= end) {
    mid = (beg + end) / 2
    if (check(A, mid) <= K) {
      end = mid - 1
      result = mid
    }
    else {
      beg = mid + 1
    }
  }

  result
}

def check(A: Array[Int], K: Int): Int = {
  val n: Int = A.length
  var count: Int = 0
  var last: Int = -1

  for (i <- 0 until n) {
    if (A(i) == 1 && last < i) {
      count +=1
      last = i + K - 1
    }
  }
  count
}