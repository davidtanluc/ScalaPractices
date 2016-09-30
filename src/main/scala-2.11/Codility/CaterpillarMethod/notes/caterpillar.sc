/* https://codility.com/media/train/13-CaterpillarMethod.pdf

 */
val A = Array(6, 2, 7, 4, 1, 3, 6)
//caterpillarMethod(A,3)//true
caterpillarMethod(A,12)//true 7,4,1
//caterpillarMethod(A,2)//false
//caterpillarMethod(A,4)//false
def caterpillarMethod(A: Array[Int], s: Int): Boolean = {
  val n = A.length
  var front = 0
  var total = 0
  for (back <- 0 until n) {
    while (front < n && total + A(front) <= s) {
      total += A(front)
      front += 1
    }

    if (total == s) return true
    total -= A(back)
  }
  false
}