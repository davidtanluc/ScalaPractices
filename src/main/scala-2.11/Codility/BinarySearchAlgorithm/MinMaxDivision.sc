/*

Task description
You are given integers K, M and a non-empty zero-indexed array A consisting of N integers. Every element of the array is not greater than M.

You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

The large sum is the maximal sum of any block.

For example, you are given integers K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
The array can be divided, for example, into the following blocks:

[2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.

 */
def solution(K:Int,M:Int,A: Array[Int]) = {
  val dp = Array.fill(A.length + 1)(0)
  for (i <- A.indices) dp(i + 1) = dp(i) + A(i)
  var left = A.max //start
  var right = dp.max

  while(left<=right){
    val mid = (left+right)/2
    val intervals = findInterval(A,mid)
    if(intervals>K){
      left = mid +1
    }else{
      right = mid -1
    }
  }

  left

}
def findInterval(A: Array[Int], target: Int): Int = {
  var sum = 0
  var count = 0
  for (i <- A.indices) {
    sum += A(i)
    if (sum > target) {
      ///move to next block
      count += 1
      sum = A(i) //resets
    }
  }
  count + (if(sum>0) 1 else 0)
}
val K : Int = 3
val M : Int = 5
val A : Array[Int] = Array(2, 1, 5, 1, 2, 2, 2)
solution(K,M,A)//6
//100 %
//https://codility.com/demo/results/trainingGT6XVS-WSM/
