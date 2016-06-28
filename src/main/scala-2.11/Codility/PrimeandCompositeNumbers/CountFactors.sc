
solution(24)  //8
def solution(N:Int)={
  var result = 0
  var divisor = 1.toLong

  val N2 = N.toLong

  while(divisor*divisor < N2){
    if(N%divisor==0)result +=2
    divisor +=1
  }
  if(divisor*divisor ==N2)result +=1

  result

}
//https://codility.com/demo/results/trainingHF84B5-HRB/