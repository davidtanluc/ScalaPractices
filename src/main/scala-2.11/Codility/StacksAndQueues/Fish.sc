import scala.collection.mutable

/*
0 Upstream (right to left)
1 Downstream (left to right)
 */
val A = Array(4,3,2,1,5)
val B = Array(0,1,0,0,0)
A zip B
solution(A,B,B.length) //2
def solution(A:Array[Int],B:Array[Int],N:Int): Int ={
  val b1= B.indexWhere(_ == 1)
  val b2= B.indexWhere(_ == 0)
  if(b1== -1 || b2 == -1)return B.length //all same direction

  if(B.length == 1)return 1

  val zip1 = A zip B
  val downstream = mutable.Stack[(Int,Int)]()
  var upstreamfish = 0

  for(i <- zip1.indices){
    if(zip1(i)._2 == 1){
      downstream.push(zip1(i))
    }else{
      if(downstream.isEmpty){
        upstreamfish +=1
      } else{ //not empty
      var k = true
        while(k){
          val prev = downstream.pop()
          val current = zip1(i)
          if(current._1 > prev._1 && downstream.isEmpty){
            upstreamfish +=1
            k=false //end
            //eat 1
          }
          if(current._1 < prev._1){
            downstream.push(prev) //save previous
            k=false //end
          }
          if(current._1 == prev._1){
            downstream.push(prev) //save previous
            upstreamfish +=1
            k=false //end
          }
        }
      }
    }
  }
  //println(downstream.size," ",upstreamfish)

  downstream.size + upstreamfish
}
//https://codility.com/demo/results/trainingKR8YFH-UY4/