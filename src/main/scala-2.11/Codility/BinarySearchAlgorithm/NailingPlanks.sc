/*
You are given two non-empty zero-indexed arrays A and B consisting of N integers. These arrays represent N planks. More precisely, A[K] is the start and B[K] the end of the K−th plank.

Next, you are given a non-empty zero-indexed array C consisting of M integers. This array represents M nails. More precisely, C[I] is the position where you can hammer in the I−th nail.

We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].

The goal is to find the minimum number of nails that must be used until all the planks are nailed. In other words, you should find a value J such that all planks will be nailed after using only the first J nails. More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].

For example, given arrays A, B such that:

    A[0] = 1    B[0] = 4
    A[1] = 4    B[1] = 5
    A[2] = 5    B[2] = 9
    A[3] = 8    B[3] = 10
four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].

Given array C such that:

    C[0] = 4
    C[1] = 6
    C[2] = 7
    C[3] = 10
    C[4] = 2
if we use the following nails:

0, then planks [1, 4] and [4, 5] will both be nailed.
0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
0, 1, 2, 3, then all the planks will be nailed.
Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed.
 */
def findNail(plankStart: Int,
                     plankEnd: Int,
                     posMap: Array[Array[Int]],
                     prePos: Int): Int = {
  var start = 0
  var end = posMap.length - 1
  var pos = -1

  while (start <= end) {

    val mid = (start + end) / 2

    if (posMap(mid)(0) > plankEnd) {
      end = mid - 1
    }
    else if (posMap(mid)(0) < plankStart) {
      start = mid + 1
    }
    else {
      pos = mid
      end = mid - 1
    }
  }

  if (pos == -1) return pos

  var result = posMap(pos)(1)
  //find the smallest original position of nail that can nail the plank
  def smallestOriginalPosition(): Int = {

    for (i <- pos + 1 until posMap.length) {

      if (posMap(i)(0) > plankEnd) return -1
      result = Math.min(result, posMap(i)(1))
      if (result <= prePos) prePos

    }
    //
    prePos
  }
  val pp = smallestOriginalPosition()
  if (pp > -1 && pp != prePos) return pp

  result
}

def solution(A: Array[Int], B: Array[Int], C: Array[Int]): Int = {
  val posMap = Array.ofDim[Int](C.length, 2)
  for (i <- C.indices) {
    posMap(i)(0) = C(i)
    posMap(i)(1) = i

  }
  //posMap.sortWith(_(0) > _(0))
  import java.util.{Comparator, Arrays}
  Arrays.sort(posMap, new Comparator[Array[Int]]() {
    def compare(a: Array[Int], b: Array[Int]): Int = {

      if (a(0) > b(0)) 1 else if (a(0) == b(0)) 0 else -1
    }
  })
  var result = 0
  //find the earliest position that can nail each plank, and the max value
  // for all planks is the result
  for (i <- A.indices) {
    val tmp = findNail(A(i), B(i), posMap, result)
    if (tmp == -1 || tmp == A.length - 1) {
      return if (tmp == -1) tmp else tmp + 1
    }
    result = result max tmp
  }

  result + 1
}

val A: Array[Int] = Array(1, 4, 5, 8)
val B: Array[Int] = Array(4, 5, 9, 10)
val C: Array[Int] = Array(4, 6, 7, 10, 2)
println(solution(A, B, C)) //4
// 100 % scala
//https://codility.com/demo/results/trainingAYAFZA-XXZ/