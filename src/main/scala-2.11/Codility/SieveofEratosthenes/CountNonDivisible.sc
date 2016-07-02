solution(Array(3,1,2,3,6))
def solution(A:Array[Int]):Array[Int]={
  /*
  goal 3 -> {2,6}   (not divisible)
       1 -> {3,2,3,6}   (not divisible)
       2 -> {3,3,6} (not divisible)
       3 -> {2,6}   (not divisible)
       6-> {} (not divisible)
       loop 1 -> 0 to indices
       loop 2 -> find divisible skip itself
   */
  import scala.collection.mutable
  val occurrences = mutable.Map[Int,Int]()

  for(i <- A.indices){//n
  var count = 0
    if(!occurrences.isDefinedAt(A(i))){
      for(j <- A.indices){ //log n
        if(j!=i && A(i)%A(j) != 0)count +=1
      }
      occurrences(A(i))=count
    }
  }
  //// result////
  A.map(occurrences)
}

//https://codility.com/demo/results/training6MEGZ4-FJ3/
// todo 88 %
/*
large_random
large, random numbers, length = ~30,000 ✘TIMEOUT ERROR
running time: 7.35 sec., time limit: 6.14 sec
 */