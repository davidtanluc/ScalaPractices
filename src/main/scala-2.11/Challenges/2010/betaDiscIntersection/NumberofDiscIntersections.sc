/*

We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers,
specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point
(assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

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
// 87%
//https://codility.com/demo/results/trainingNACCQN-E9X/
// todo