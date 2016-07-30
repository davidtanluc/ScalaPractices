////// WAYS to change money //////////////
def countChange(coins:List[Int],money:Int)= {
  //val ways = Array(1,0,0,0,0,0,0,0)
  val ways = new Array[Int](money + 1)
  ways(0) = 1
  for (coin <- coins) {//1,3
    for (coin_value_to_money <- coin to money) {//1..6, 3..6
      ways(coin_value_to_money) += ways(coin_value_to_money - coin)
      //println(value," coint",coin,"ways",ways.toList)
      /*
(1, coint,1,ways,List(1, 1, 0, 0, 0, 0, 0))
(2, coint,1,ways,List(1, 1, 1, 0, 0, 0, 0))
(3, coint,1,ways,List(1, 1, 1, 1, 0, 0, 0))
(4, coint,1,ways,List(1, 1, 1, 1, 1, 0, 0))
(5, coint,1,ways,List(1, 1, 1, 1, 1, 1, 0))
(6, coint,1,ways,List(1, 1, 1, 1, 1, 1, 1))
(3, coint,3,ways,List(1, 1, 1, 2, 1, 1, 1))
(4, coint,3,ways,List(1, 1, 1, 2, 2, 1, 1))
(5, coint,3,ways,List(1, 1, 1, 2, 2, 2, 1))
(6, coint,3,ways,List(1, 1, 1, 2, 2, 2, 3))
       */
    }
  }
  ways.toList
}
////////////////////////////////////////////////////////////
def max_coins(coins:List[Int],money:Int)={
  val dp = Array(0) ++ Array.fill(money)(Int.MinValue)

  for(coin <- coins){
    for(coin_value_to_money<-coin to money){
      dp(coin_value_to_money) = dp(coin_value_to_money-coin)+1 max dp(coin_value_to_money)
      //println(dp.toList)
      /*
List(0, 1, -2147483648, -2147483648, -2147483648, -2147483648, -2147483648)
List(0, 1, 2, -2147483648, -2147483648, -2147483648, -2147483648)
List(0, 1, 2, 3, -2147483648, -2147483648, -2147483648)
List(0, 1, 2, 3, 4, -2147483648, -2147483648)
List(0, 1, 2, 3, 4, 5, -2147483648)
List(0, 1, 2, 3, 4, 5, 6)
List(0, 1, 2, 3, 4, 5, 6)
List(0, 1, 2, 3, 4, 5, 6)
List(0, 1, 2, 3, 4, 5, 6)
List(0, 1, 2, 3, 4, 5, 6)
List(0, 1, 2, 3, 4, 5, 6)
       */
    }
  }
  dp.toList
}
/////  minimum number of coins with the given amount of money ///
def min_coins(coins:List[Int],money:Int)={
  val dp = Array(0) ++ Array.fill(money)(Int.MaxValue)

  for(coin <- coins){//1,3
    for(coin_value_to_money <-coin to money){// 1...6 ;;3..6
      dp(coin_value_to_money) = dp(coin_value_to_money - coin) + 1 min dp(coin_value_to_money)
      //println(dp.toList)
      /*
List(0, 1, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647)
List(0, 1, 2, 2147483647, 2147483647, 2147483647, 2147483647)
List(0, 1, 2, 3, 2147483647, 2147483647, 2147483647)
List(0, 1, 2, 3, 4, 2147483647, 2147483647)
List(0, 1, 2, 3, 4, 5, 2147483647)
List(0, 1, 2, 3, 4, 5, 6)
List(0, 1, 2, 1, 4, 5, 6)
List(0, 1, 2, 1, 2, 5, 6)
List(0, 1, 2, 1, 2, 3, 6)
List(0, 1, 2, 1, 2, 3, 2)
List(0, 1, 2, 1, 2, 3, 2)
       */
    }
  }
  dp.toList
}
val coins =List(1,3)
val money = 6
//println(countChange(coins,money))//List(1, 1, 1, 2, 2, 2, 3)
//println(min_coins(coins,money))//List(0, 1, 2, 1, 2, 3, 2)
//println(max_coins(coins,money))//List(0, 1, 2, 3, 4, 5, 6)
