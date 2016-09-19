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

  if (xs.length > 1) {
    val n = xs.length / 2
    val (fst, snd) = xs splitAt n
    //println(fst.toList,snd.toList)
    /*
(List(-1, 6, 3),List(4, 7, 4))
(List(-1),List(6, 3))
(List(6),List(3))
////
(List(4),List(7, 4))
(List(7),List(4))
 */

    inversion_count += mergeSort(fst)
    if (inversion_count > MAX_NR) return -1
    inversion_count += mergeSort(snd)
    if (inversion_count > MAX_NR) return -1

    ////
    var left = 0
    var right = 0
    var k = 0

    while (left < fst.length && right < snd.length) {

      if (fst(left) <= snd(right)) {
        xs(k) = fst(left)
        left += 1

      } else {

        xs(k) = snd(right)
        right += 1
        inversion_count += fst.length - left
        if (inversion_count > MAX_NR) return -1
        
      }

      k += 1
    }
    //println("#1",xs.toList,"left",left,"right",right)
    /*
(#1,List(3, 3),left,0,right,1)
(#1,List(-1, 6, 3),left,1,right,0)
(#1,List(4, 4),left,0,right,1)
(#1,List(4, 7, 4),left,1,right,0)
(#1,List(-1, 3, 4, 4, 6, 4),left,3,right,2))
     */

    //# left
    while (left < fst.length) {
      xs(k) = fst(left)
      left += 1
      k += 1
    }
    //println("#Left",xs.toList)
    /*
(#Left,List(3, 6))
(#Left,List(-1, 6, 3))
(#Left,List(4, 7))
(#Left,List(4, 7, 4))
(#Left,List(-1, 3, 4, 4, 6, 4))
     */

    //# right
    while (right < snd.length) {
      xs(k) = snd(right)
      right += 1
      k += 1
    }
    // println("#Right",xs.toList)
    /*
(#Right,List(3, 6))
(#Right,List(-1, 3, 6))
(#Right,List(4, 7))
(#Right,List(4, 4, 7))
(#Right,List(-1, 3, 4, 4, 6, 7))
     */
  }
  //
  inversion_count
}
// Main //
val A = Array(-1, 6, 3, 4, 7, 4)
solution(A) //4
def solution(A: Array[Int]) = mergeSort(A)
//100 %
//https://codility.com/demo/results/trainingCR6YD6-9FP/

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