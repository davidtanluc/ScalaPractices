solution(30) ==22
solution(50) == 30
def solution(N:Int)={
  var min1 = Int.MaxValue
  for(i<-2 to Math.sqrt(N).toInt){
    if( N % i == 0) {
      min1 = min1 min 2 * (i + N/i)
    }
  }
  //// 1 versus itself ///
  min1 = min1 min 2 * (1 + N)
  min1
}

//https://codility.com/demo/results/trainingZG6JKH-XJ6/