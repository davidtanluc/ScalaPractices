/*
A zero-indexed array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].

Write a function:

def solution(A)
that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
For example, in the following array:

 A[0] = -1 A[1] = 6 A[2] = 3
 A[3] =  4 A[4] = 7 A[5] = 4
there are four inversions:

   (1,2)  (1,3)  (1,5)  (4,5)
so the function should return 4.

Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */
val MAX_NR = 1000000000
//mergeSort(A)
def mergeSort(xs: Array[Int]): Int = {
  var inversion_count = 0
  if (xs.length < 2) return inversion_count
  /* xs is NOT sorted */
  val n = xs.length / 2
  val (left, right) = xs splitAt n

  /* mergesort left , mergesort right */
  inversion_count += mergeSort(left)
  if (inversion_count > MAX_NR) return -1
  inversion_count += mergeSort(right)
  if (inversion_count > MAX_NR) return -1
  ////
  var left_idx = 0
  val left_size = left.length
  var right_idx = 0
  val right_size = right.length
  var k = 0

  while (left_idx < left_size && right_idx < right_size) {

    if (left(left_idx) <= right(right_idx)) {
      xs(k) = left(left_idx)
      left_idx += 1

    } else {
      xs(k) = right(right_idx)
      right_idx += 1

      inversion_count += left_size - left_idx
      if (inversion_count > MAX_NR) return -1

    }

    k += 1
  }
  //println("#1",xs.toList,"left",left,"right",right)
  //# left
  while (left_idx < left_size) {
    xs(k) = left(left_idx)
    left_idx += 1
    k += 1
  }
  //println("#Left",xs.toList)

  //# right
  while (right_idx < right_size) {
    xs(k) = right(right_idx)
    right_idx += 1
    k += 1
  }
  // println("#Right",xs.toList)
  //
  inversion_count
}
// Main //
val A = Array(-1, 6, 3, 4, 7, 4)
solution(A) //4
def solution(A: Array[Int]) = mergeSort(A)
//100 %
//https://codility.com/c/run/trainingFFAVUD-4B5

/*

============================
Problem Introduction
============================

An inversion of a sequence a0, a1, . . . , an−1 is a pair of indices 0 ≤ i < j < n such
that ai > aj . The number of inversions of a sequence in some sense measures how
close the sequence is to being sorted. For example, a sorted (in non-descending
order) sequence contains no inversions at all, while in a sequence sorted in de-
scending order any two elements constitute an inversion (for a total of n(n − 1)/2
inversions).

This problem can be solved by modifying the merge sort algorithm. For this, we change both
the Merge and

--------------------------------
MergeSort procedures as follows:
--------------------------------

∙ Merge(B, C) returns the resulting sorted array and the number of pairs (b, c)
such that b ∈ B, c ∈ C, and b > c;

∙ MergeSort(A) returns a sorted array A and the number of inversions in A.

 */