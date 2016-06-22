/*
   A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0

  disc intersects when
  position1 +radius1 >=position2 - radius2

  example left to right

  0+1 !>= 1-5
  1+5>=3-1
  3+1>=4-4
 */
val A = Array(1,5,2,1,4,0)
solution(A:Array[Int])
def solution(A:Array[Int]):Int={ //
val plusses = A.zipWithIndex map( x=>x._1 + x._2)
  val minuses = A.zipWithIndex map(x=> x._2 - x._1)
  var count = 0
  for(i<-0 until plusses.length-1){
    for(j<-i+1 until plusses.length){
      if(plusses(i)>=minuses(j))count +=1
    }
  }
  count
}

// todo