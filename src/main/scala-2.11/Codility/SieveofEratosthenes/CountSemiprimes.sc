/*
integers are 2, 3, 5, 7, 11 and 13.
The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
 */
def isSemiPrime(elem:Int):Boolean = {
  var countisTwo = 0
  var l = elem
  // start from 2 ;; last value is elem/2
  for (i <- 2 to elem / 2) {
    while (l % i == 0) {
      if (countisTwo == 2) return false
      countisTwo += 1
      l /= i
    }
  }
  countisTwo == 2
}
solution(26,Array(1,4,16),Array(26,10,20))
def solution(N:Int,P:Array[Int],Q:Array[Int])={
  val semiprime = (1 to N).scan(0)((acc,elem)=>if(isSemiPrime(elem))acc+1 else acc).view //
  (P zip Q).map{token => semiprime(token._2)-semiprime(token._1-1)}

}
//https://codility.com/demo/results/trainingTYBQ2W-SNS/