val S = "CAGCCTA"
val P = Array(2,5,0)
val Q =Array(4,5,6)


def solution(S:String,P:Array[Int],Q:Array[Int]):Array[Int]= {
  val values = S.view.par.map {
    case 'A' => 1
    case 'C' => 2
    case 'G' => 3
    case 'T' => 4
  }
  (P zip Q) map { case (p, q) => values.slice(p, q + 1).min }
}

//https://codility.com/demo/results/trainingYKMNGS-3BD/ 62%