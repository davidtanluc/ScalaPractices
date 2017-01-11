import scala.collection.immutable.HashMap

var freq = HashMap[Int,Int]()


def solution(A:Array[Int])={
  val xs = A.toList
  var freq = HashMap[Int,Int]()
  xs.foreach{
    token =>
      freq = freq + (token-> (freq.getOrElse(token,0)+1))
  }
  freq.find { case (key, value) => value % 2 == 1 }.get._1
}

val A = Array(9,3,9,3,9,7,9)
solution(A)


//https://codility.com/demo/results/trainingS6NMB6-HJ6/  88%