/*
 It is not possible to produce four such ropes.

Write a function:

int solution(int K, int A[], int N);
that, given an integer K and a non-empty zero-indexed array A of N integers, returns the maximum number of ropes
 of length greater than or equal to K that can be created.

For example, given K = 4 and array A such that:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 1
    A[5] = 1
    A[6] = 3
the function should return 3, as explained above.

Assume that:

N is an integer within the range [1..100,000];
K is an integer within the range [1..1,000,000,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */
val K = 4
val A = Array(1,2,3,4,1,1,3)
solution(K,A)
def solution(K:Int, A:Array[Int]):Int={

  var cnt = 0
  var current = 0
  for(part <- A){
    //println(part)
    current += part
    if (current >= K) {
      cnt +=1
      current = 0
    }
  }

  cnt
}
// 100 %
//https://codility.com/demo/results/trainingJXKUJ2-K2R/