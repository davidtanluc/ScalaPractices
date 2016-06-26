//solution(Array(1, -2, 0, 9, -1, -2)) == 8
solution(Array(1, -2, 0, 9, -1, -2))
def solution(A:Array[Int])={
  val dp = Array.fill(6)(A(0)) //six face dice

  for(i <- 1 until A.length){
    dp(i % 6) = dp.max + A(i)
  }

  //dp//Array(1, -1, 1, 10, 9, 8)
  dp((A.length-1) % 6) //8
}

//https://codility.com/demo/results/trainingDW2K6J-C34/