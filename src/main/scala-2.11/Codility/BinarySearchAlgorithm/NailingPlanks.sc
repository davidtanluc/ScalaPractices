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