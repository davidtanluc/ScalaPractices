//https://codility.com/demo/results/trainingBNFT3Y-WQT/

val X = 10
val Y = 80
val D = 30

solution(X,Y,D)
def solution(X:Int,Y:Int,D:Int):Int ={
  val answer = (Y-X)/D
  val hasbalance = (Y-X) % D
  if(hasbalance == 0) return answer
  answer + 1
}