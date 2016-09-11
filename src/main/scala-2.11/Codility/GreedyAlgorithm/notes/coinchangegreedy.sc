import java.util

/*

https://codility.com/media/train/14-GreedyAlgorithms.pdf

 For a given set of denominations, you are asked to find the minimum number of coins with
which a given amount of money can be paid. That problem can be approached by a greedy
algorithm that always selects the largest denomination not exceeding the remaining amount
of money to be paid. As long as the remaining amount is greater than zero, the process is
repeated.

A correct algorithm should always return the minimum number of coins. It turns out
that the greedy algorithm is correct for only some denomination selections, but not for all.

For example, for coins of values 1, 2 and 5 the algorithm returns the optimal number of
coins for each amount of money, but for coins of values 1, 3 and 4 the algorithm may return
a suboptimal result. An amount of 6 will be paid with three coins: 4, 1 and 1 by using the
greedy algorithm. The optimal number of coins is actually only two: 3 and 3.

Greedy strategy

Find max digit

Append it to the number

Remove it from the list of digits

Repeat while there are digits in the list
 */
def greedyCoinChanging(coins:Array[Int], dollar_value :Int) ={
  val n = coins.length
  var k = dollar_value
  val result = new util.ArrayList[(Int,Int)]
  for(i<-n-1 to 0 by -1){
    result.add((coins(i), k  / coins(i)))
    k = k % coins(i)
  }
  result

}

//greedyCoinChanging(Array(1,2,5),6)
//greedyCoinChanging(Array(1,2,5),3)
//
////////////////////////////////////
//
//greedyCoinChanging(Array(1,3,4),6)//res2: java.util.ArrayList[(Int, Int)] = [(4,1), (3,0), (1,2)]
//greedyCoinChanging(Array(1,3,4),3)//res3: java.util.ArrayList[(Int, Int)] = [(4,0), (3,1), (1,0)]

greedyCoinChanging2(Array(1,3,4),6)//res0: List[(Int, Int)] = List((1,2), (3,0), (4,1))
greedyCoinChanging2(Array(1,3,5),6)//res1: List[(Int, Int)] = List((1,1), (3,0), (5,1))
greedyCoinChanging2(Array(1,3,4),3)//res2: List[(Int, Int)] = List((1,0), (3,1), (4,0))

def greedyCoinChanging2(coins:Array[Int], dollar_value :Int) = {
    coins.
    reverse.
    foldLeft((List[(Int,Int)](),dollar_value))({
    (acc,el) => {
      val k = acc._2
      ((el,k / el)::acc._1, k % el)
    }})._1

}
