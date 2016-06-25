/*
A[0] = 3    A[1] = 4    A[2] =  3
A[3] = 2    A[4] = 3    A[5] = -1
A[6] = 3    A[7] = 3
 */
val A = Array(3,4,3,2,3,-1,3,3)
/*
The dominator of array A is the value that occurs
in more than half of the elements of A.

expected worst-case time complexity is O(N);

 */
solution(A)
def solution(A:Array[Int]):Int={
  if(A.isEmpty) return -1
  if(A.length ==1)return 0 //position 0 is the max

  val dict1 = A.toList.map((_,1)).
    groupBy(_._1).
    map(d=>(d._1,d._2.length)).maxBy(_._2)


  val key = dict1._1
  val frequency = dict1._2

  if(frequency * 2 > A.length){
    return  A.indexWhere(_ == key)
  }

  -1
}
//https://codility.com/demo/results/trainingWVK299-TQD/