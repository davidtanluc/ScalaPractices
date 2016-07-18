def solution(K:Int,M:Int,A: Array[Int]) = {
  val dp = Array.fill(A.length + 1)(0)
  for (i <- A.indices) dp(i + 1) = dp(i) + A(i)
  var left = A.max //start
  var right = dp.max

  while(left<=right){
    val mid = (left+right)/2
    val intervals = findInterval(A,mid)
    if(intervals>K){
      left = mid +1
    }else{
      right = mid -1
    }
  }

  left

}
def findInterval(A: Array[Int], target: Int): Int = {
  var sum = 0
  var count = 0
  for (i <- A.indices) {
    sum += A(i)
    if (sum > target) {
      ///move to next block
      count += 1
      sum = A(i) //resets
    }
  }
  count + (if(sum>0) 1 else 0)
}
val K : Int = 3
val M : Int = 5
val A : Array[Int] = Array(2, 1, 5, 1, 2, 2, 2)
solution(K,M,A)//6

//https://codility.com/demo/results/trainingGT6XVS-WSM/
//