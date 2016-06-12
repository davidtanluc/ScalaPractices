def Solution(A:Array[Int],K:Int):Array[Int]={
  if(A.isEmpty)return A

  val n = A.length
  val new_array = new Array[Int](n)

  for(item <-A.zipWithIndex){
    new_array(newPosition(item._2,n,K)) = item._1

  }

  def newPosition(current:Int, n:Int,k:Int):Int= {
    val K = k % n // if k exceeds n new K
    val diff = current + K
    if(diff>n-1)return diff - n
    diff
  }

  new_array
}
//Solution(Array(3,8,9,7,6),3)//Array(9, 7, 6, 3, 8)
//https://codility.com/demo/results/trainingGNQ8MQ-CM4/