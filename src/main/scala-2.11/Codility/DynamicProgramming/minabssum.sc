/*

https://codility.com/media/train/solution-min-abs-sum.pdf

For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:

val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
(Assume that the sum of zero elements equals zero.)

For a given array A, we are looking for such a sequence S that minimizes val(A,S).

Write a function:

int solution(int A[], int N);
that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

For example, given array:

  A[0] =  1
  A[1] =  5
  A[2] =  2
  A[3] = -2
your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

Assume that:

N is an integer within the range [0..20,000];
each element of array A is an integer within the range [−100..100].
Complexity:

expected worst-case time complexity is O(N*max(abs(A))2);
expected worst-case space complexity is O(N+sum(abs(A))), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */
val A = Array(1, 5, 2, -2)
//your function should return 0
golden_min_abs_sum(A) //10
def golden_min_abs_sum(a: Array[Int]):Int = {

  val n = a.length
  if(n==0)return 0
  val A = a.map(Math.abs) // 1,5,2,2
  val m = A.max // 5
  val S = A.sum // 10
  val count = Array.fill(m + 1)(0)
  for (i <- 0 until n) count(A(i)) += 1
  //println(count.toList)
  //Count : List(0, 1, 2, 0, 0, 1)
  val dp = Array(0) ++ Array.fill(S)(-1)
  //DP: List(0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1)
  //println(dp.toList)

  for (a <- 1 to m // 1 to 5 ;; 1,2,0,0,1
       if count(a) > 0;
       j <- 0 until S) {// 0 to 9

    if (dp(j) >= 0) dp(j) = count(a)

    else if (j >= a && dp(j - a) > 0) dp(j) = dp(j - a) - 1

  }
  //DP: List(1, 1, 1, 1, 1, 1, 0, 0, 0, 0, -1)
  /////
  var result = S

  for (i <- 0 until (S / 2) + 1
       if dp(i) >= 0) result = result min S - 2 * i

  result
}
//100 %
//https://codility.com/demo/results/trainingUW6XRK-DTY/