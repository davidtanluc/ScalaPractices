def countIntervals(A: Array[Int], target: Int): Int = {
  var sum: Int = 0
  var count: Int = 0
  for(i<-A.indices){
    sum +=A(i)
    if(sum>target){
      count +=1
      sum =A(i)
    }
  }
  count + (if (sum > 0) 1 else 0)
}

def solution(K: Int, M: Int, A: Array[Int]): Int = {
  val n: Int = A.length
  val prefsum: Array[Int] = new Array[Int](n + 1)
  var maxNumber: Int = 0
  prefsum(0) = 0
  for(i<-1 to n){
    prefsum(i) = prefsum(i-1) + A(i-1)
    maxNumber =maxNumber max A(i-1)
  }
  var left: Int = maxNumber
  var right: Int = prefsum(n)
  while (left <= right) {
    val mid: Int = (left + right) / 2
    val intervals: Int = countIntervals(A, mid)
    if (intervals > K) {
      left = mid + 1
    }
    else {
      right = mid - 1
    }
  }//while

  left
}
val K : Int = 3
val M : Int = 5
val A : Array[Int] = Array(2, 1, 5, 1, 2, 2, 2)
solution(K,M,A)//6

//https://codility.com/demo/results/trainingQYGCYF-Y99/