val A = Array(23171,21011, 21123,21366,21366,21367)
def solution(A:Array[Int]):Int={
  if(A.length < 2)return 0 //less than 2 no profit

  var max_profit = Int.MinValue
  var min_price = A(0)

  for(i <- 1 until A.length){
    min_price = min_price min A(i)
    max_profit = max_profit max (A(i)- min_price)
  }
  max_profit

}
solution(A)

//https://codility.com/demo/results/trainingGSQKDY-NQM/