solution(6,11,2)
def solution(A:Int,B:Int,K:Int):Int={

  var result = B/K - A/K
  if(A % K==0)result +=1

  result
}

//https://codility.com/demo/results/trainingETJ2PZ-BZH/
