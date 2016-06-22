val A =Array(2,1,1,2,3,1)
solution(A)
def solution(A:Array[Int]):Int={
  if(A.isEmpty)return 0
  val sorted = A.sorted
  var count = 1
  var previous = sorted(0)
  for(i <- 1 until sorted.length){
    val current = sorted(i)
    if(previous != current){
      previous = current
      count +=1
    }
  }
  count

}

//https://codility.com/demo/results/trainingW8Z65M-VA6/