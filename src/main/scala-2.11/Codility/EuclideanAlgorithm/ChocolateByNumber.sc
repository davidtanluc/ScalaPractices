solution(10,4)//5
def solution(N:Int,M:Int):Int={

  import scala.annotation.tailrec
  @tailrec
  def gcd(a:Long,b:Long):Long={
    if(a%b ==0)b else gcd(b,a%b)
  }
  val result = M.toLong*N.toLong / gcd(N.toLong,M.toLong)
  (result / M.toLong).toInt
}
//https://codility.com/demo/results/training2PVNAD-ABX/