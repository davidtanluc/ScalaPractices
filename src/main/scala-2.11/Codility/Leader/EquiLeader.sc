val A = Array(4,3,4,4,4,2)

solution(A)
def solution(A:Array[Int]):Int = {

  val a = A.toList.map((_,1)).
    groupBy(_._1).
    map(d=>(d._1,d._2.length)). //Map(4->4)
    maxBy(_._2) // Max by frequency or value in key -> value

  val leader = a._1

  if (a == null || a._2 * 2 <= A.length) 0

  var fromA = A.length
  var freqA = a._2
  var fromB = 0
  var freqB = 0
  var count =0

  for(i <- A.indices){
    fromA -=1
    fromB +=1
    if(A(i) == leader){
      freqB +=1
      freqA -=1
    }

    if(hasLeader(freqA,fromA) && hasLeader(freqB,fromB)) count +=1

  }
  /*
  The leader of this array is the value that occurs in more than
  half of the elements of A.
   */
  def hasLeader(freq:Int, current_length:Int):Boolean = {
    2 * freq > current_length
  }

  count
}

////////////////
// 100 %
//https://codility.com/demo/results/trainingU3ESCW-BH7/
//https://codility.com/demo/results/trainingC4WF43-VKA/
