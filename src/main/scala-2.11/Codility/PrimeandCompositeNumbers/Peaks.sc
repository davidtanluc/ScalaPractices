val A = Array(1,2,3,4,3,4,1,2,3,4,6,2)
def solution(A:Array[Int]):Int={
  val N = A.length
  if(N < 2)return 0 // NONe
  val lifted = A.lift


  import scala.annotation.tailrec
  @tailrec
  def loop(start:Int,end:Int, result:List[Int]):List[Int]={
    if(start==end)return result
    val left = lifted(start-1).getOrElse(-1)
    val middle = lifted(start).getOrElse(-1)
    val right= lifted(start+1).getOrElse(-1)


    if(left > -1
      && right > -1
      && middle > -1
      && left < middle
      && middle > right) {
      loop(start+1,end,start::result)
    }else{
      loop(start+1,end,result) //skip
    }
  }

  val peaks = loop(1,N-1,List()).sorted//3,5,10

 ////// find blocks///////////////
  for(size <- 1 to N){
    if(N %size ==0){
      var find = 0
      val groups = N / size // 12/1...12/12
      var found = true

      for(peakIdx <- peaks){//3,5,10 ;; size 1...12
        if( peakIdx/size > find){
          found = false
        }else{
          if (peakIdx / size == find) find += 1
        }
      }//for 2
      if (find != groups) found = false
      if (found) return groups
    }//N%0
  }//for1

  0 // if nothing
}
solution(A)//https://codility.com/demo/results/trainingB74GHB-2BU/