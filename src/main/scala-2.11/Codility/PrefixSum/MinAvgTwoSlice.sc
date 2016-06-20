val A = Array(4,2,2,5,1,5,8)
solution(A)
def solution(A:Array[Int]):Int={
  var min_index = 0 //starting
  var min_avg = (A(0)+A(1))/2.0 ///// at least two
  //N is an integer within the range [2..100,000];
  for(i <- 1 until A.length){
    val avg2 = (A(i)+A(i-1))/2.0
    if(min_avg>avg2){
      min_avg = avg2
      min_index = i-1
    }

    if(i>1){
      val avg3 = (A(i)+A(i-1)+A(i-2))/3.0
      if(min_avg>avg3){
        min_avg = avg3
        min_index = i-2
      }
    }
  }
  min_index
}
//https://codility.com/demo/results/trainingBUAB49-88T/