//https://codility.com/programmers/task/triangle/
val A = Array(10,2,5,1,8,20)
//for(i<-0 until A.length){//10...20
//for(i<-0 until A.length-2){//10...1
//  println(A(i))
//}
val B = Array(10,50,5,1)
solution(A)
solution(B)
def solution(A:Array[Int]):Int={
  val sorted = A.sorted
  val n = A.length
  if(n<3)return 0


  val middle = A.length /2
  if(middle<3){
    for(i<-1 until n-1){//last one
      if(pivot(i)==1)return 1
    }
  }else{
    val end = A.length - 1
    var right = middle
    while(right< end){ //-2
      if(pivot(right)==1)return 1
      right +=1
    }
    var left = middle + 1
    while(left>0){//last 2
      if(pivot(left)==1)return 1
      left -=1
    }
  }

  def pivot(n:Int):Int={
    val left = sorted(n - 1).toLong
    val middle = sorted(n).toLong
    val right = sorted(n+1).toLong
    if(left+middle> right && middle+right > left && right+left>middle)return 1
    0
  }

  0
}
//https://codility.com/demo/results/trainingFAYYR7-S3B/