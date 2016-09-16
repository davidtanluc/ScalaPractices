//https://codility.com/demo/results/trainingPRTMPK-AMR/

def solution(N:Int):Int={
  val binaryRepresentation = N.toBinaryString.reverse
  var max1 = 0
  var sum = 0
  var notrailingzeroes = false // remove trailing zeroes
  for(item <-binaryRepresentation ){
    if (item == '1') {notrailingzeroes =true;sum = 0} else sum = sum + 1 //resets
    if(notrailingzeroes) max1 = max1 max sum
  }
  max1
}

solution(529)//4
solution(1041)//5

// 100 %
//https://codility.com/demo/results/trainingJ9WNGX-N3X/