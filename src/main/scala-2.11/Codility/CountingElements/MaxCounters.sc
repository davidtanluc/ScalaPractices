val A = Array(3,4,4,6,1,4,4)
val N = 5
solution(N,A)
//////////////////////////////////////////
def solution(N:Int,A:Array[Int])={
  val startArray = new Array[Int](N)
  var max1 = 0
  var max_counter = 0
  for(elem <- A){
    if(elem <= N){
      val tmp = startArray(elem-1)
      if(tmp< max_counter) startArray(elem-1) = max_counter +1 //increase X
      else startArray(elem-1) +=1

      max1 = max1 max startArray(elem-1)

    }else if(elem == N+1){
      max_counter = max1 max max_counter // new max counter
    }
  }
  //// results
  startArray.map(elem => if(elem<max_counter)max_counter else elem)

}

//https://codility.com/demo/results/trainingT28VBP-TXJ/