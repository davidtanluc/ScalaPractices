val A = Array(-3,1,2,-2,5,6)
solution(A)
def solution(A:Array[Int]):Int={
  val sorted = A.sorted
  //println(sorted.toList)
  val n = sorted.length
  if(sorted.length<3)return 0
  val last_value = sorted(n-1)
  ////// for negative value
  val max_head = sorted(0)* sorted(1)* last_value // assuming two negatives and one positive
  val max_tail = sorted(n-1)*sorted(n-2)*sorted(n-3)
  //println(max_head,max_tail)

  max_head max max_tail
}


//https://codility.com/demo/results/training5EPJJ5-4HY/
