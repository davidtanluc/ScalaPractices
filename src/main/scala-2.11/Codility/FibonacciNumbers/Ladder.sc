/////////////////////////////
solution(Array(4, 4, 5, 5, 1 ),Array(3, 2, 4, 3, 1))
//res0: Array[Int] = Array(5, 1, 8, 0, 1)

def solution(A:Array[Int],B:Array[Int]):Array[Int]={
  val n = A.length
  val sortedA = A.sorted.view

  val maxDistance: Int = sortedA(n - 1) //5
  val dp: Array[Int] = new Array[Int](maxDistance + 1)

  dp(0) = 1
  dp(1) = 1
  val result = new Array[Int](n)

  for(i<-2 to maxDistance){
    for(j<-1 to 2){// check previous 2 does not exceed max integer
      dp(i) += dp(i - j) % (1 << 30)// 1073741824
    }
  }
  //A[I] rungs modulo 2^B[I]
  for(x<-0 until n){
    result(x) = dp(A(x)) % Math.pow(2,B(x)).toInt //2^B(x)

  }
  result//Array(5, 5, 8, 8, 1) without modulo
}

//https://codility.com/demo/results/trainingQQE7A9-ZB4/