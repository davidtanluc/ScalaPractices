/*
val  A = Array(1,4,-3)          //1
val  A2 = Array(-8,4,5,-10,3)  //3
val  A3 = Array(1)  //2
N is an integer within the range [1..100,000];
each element of array A is an
integer within the range [−1,000,000,000..1,000,000,000].

-10 , - 8 ;; 3,4,5
 */

solution(Array(-8,4,5,-10,3)) //3
solution(Array(1))//2
solution(Array(0))//0

def solution(A:Array[Int]):Int={
  val sorted = A.sorted
  var l = 0
  var r = A.length -1
  var min1 = Int.MaxValue

  while(l<=r){
    val sum1 = sorted(l) + sorted(r)
    min1 = min1 min Math.abs(sum1)
    /// if sum1 is -ve --> right move to left
    if(sum1 > 0) r -=1  else l +=1
  }
  min1

}

/*
100 %
https://codility.com/demo/results/trainingVUWTZJ-9DJ/
Let A be a non-empty zero-indexed array consisting of N integers.

The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.

For example, the following array A:

  A[0] =  1
  A[1] =  4
  A[2] = -3
has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.
Write a function:

int solution(int A[], int N);
that, given a non-empty zero-indexed array A consisting of N integers, returns the minimal abs sum of two for any pair of indices in this array.

For example, given the following array A:

  A[0] =  1
  A[1] =  4
  A[2] = -3
the function should return 1, as explained above.

Given array A:

  A[0] = -8
  A[1] =  4
  A[2] =  5
  A[3] =-10
  A[4] =  3
the function should return |(−8) + 5| = 3.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */