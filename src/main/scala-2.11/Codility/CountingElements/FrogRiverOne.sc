/*
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
 */

// MAKE MAP.... 1->0,3->1,4->3,2->4,3->5,5->6 ;;
// SORT MAP;; COMPARE MAP VALUES WITH (1 TO X)
// two list can compare each other


val A = Array(1,3,1,4,2,3,5,4)

solution(5,A)
def solution(X:Int,A:Array[Int]):Int={
  import scala.collection.mutable
  val dict1 = mutable.Map[Int,Int]()
  var index = 0
  for(elem <-A){
    if(!dict1.isDefinedAt(elem))dict1(elem) = index
    index +=1 //go to next index filter duplicate
  }
  if(dict1.keys.toList.sorted == (1 to X).toList)
    return dict1.values.max

  -1
}

//https://codility.com/demo/results/trainingHHV4YH-UMT/