val A = Array(2,3,5,1)
/*
  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5*/

solution(A)
def solution(A:Array[Int]):Int={
  if(A.isEmpty)return 1

  val sorted1 = A.sorted
  val smallest_index = sorted1.indexWhere(_ > 0)
  if(sorted1(smallest_index)>1)return 1 // 1 i missing

  for(n <- smallest_index until A.length-1){
    if(sorted1(n+1) > sorted1(n) + 1) return sorted1(n) + 1
  }
  sorted1.last + 1
}

//https://codility.com/demo/results/training3RB28P-67P/