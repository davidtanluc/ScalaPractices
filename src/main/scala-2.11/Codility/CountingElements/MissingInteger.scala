//https://codility.com/programmers/task/missing_integer/
def solution(A:Array[Int],N:Int):Int={
  val sorted = A.sorted
  val smallestIndex = sorted.indexWhere(_ > 0)
  //println(smallestIndex)
  if(smallestIndex < 0) return 1
  if(sorted(smallestIndex) > 1) return 1


  for(n <- smallestIndex until A.length-1){
    if(sorted(n+1) > sorted(n) + 1) return sorted(n) + 1
  }
  sorted.last + 1

}

println(solution(Array(-2,-3,-5,1,3,6,4,1,2),12)) // 5

//https://codility.com/demo/results/trainingWPV4MX-3NC/