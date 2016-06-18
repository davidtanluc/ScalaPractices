//https://codility.com/demo/results/trainingSERVR3-WBZ/

val H = Array(8,8,5,7,9,8,7,4,8)

def solution(H:Array[Int]):Int ={
  if(H.isEmpty)return 0
  if(H.length ==1)return 1

  val stack1 = new scala.collection.mutable.Stack[Int]()
  var min_blocks = 0

  for(elem <- H){

    while(stack1.nonEmpty && stack1.top> elem){
      stack1.pop() //remove if previous block is higher than current otherwise that block
      // is blocking the view
    }
    ///// start counting min block required ////
    if(stack1.isEmpty  || stack1.top != elem){
      stack1.push(elem)
      min_blocks += 1
    }

  }

  min_blocks
}