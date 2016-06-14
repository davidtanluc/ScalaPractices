val A = Array(3,1,2,4,3)



solution(A)
def solution(A:Array[Int]):Int ={
  val sum1 = A.sum  //sum = 13
  var min_diff = Int.MaxValue
  var sum_left_to_right = 0

  for(i <- 0 until A.length -1){
    sum_left_to_right += A(i)
    min_diff = min_diff min Math.abs(sum1 - 2 * sum_left_to_right)
  }

  min_diff
}

//https://codility.com/demo/results/trainingRCME5P-86B/