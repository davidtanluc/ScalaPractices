/*
A non-empty zero-indexed array A consisting of N numbers is given. The array is sorted in non-decreasing order.
 The absolute distinct count of this array is the number of distinct absolute values among the elements of
 the array.

For example, consider array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
The absolute distinct count of this array is 5, because there are 5 distinct absolute values among
the elements of this array, namely 0, 1, 3, 5 and 6.

Write a function:

int solution(int A[], int N);
that, given a non-empty zero-indexed array A consisting of N numbers, returns absolute distinct count of array A.

val A = Array(-5,-3,-1,0,3,6)
 */
val A = Array(-5, -3, -1, 0, 3, 6)
solution(A)
def solution(A: Array[Int]) = A.map(Math.abs).groupBy(elem => elem).size

//https://codility.com/demo/results/trainingR5P7UP-7ZJ/
//https://codility.com/demo/results/trainingAMEUHU-W8X/
// 100 %