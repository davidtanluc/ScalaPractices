//https://codility.com/media/train/8-PrimeNumbers.pdf

align_coins(10)
def align_coins(n:Int)= {
  val dp = Array.fill(n+1)(0)
  for(i<- 1 to n){
    for(value<-i to n by i){
      //print(dp(value)," ",i)
      /*
    (0, ,1)(0, ,1)(0, ,1)(0, ,1)(0, ,1)(0, ,1)(0, ,1)(0, ,1)(0, ,1)(0, ,1)
    (1, ,2)(1, ,2)(1, ,2)(1, ,2)(1, ,2)
    (1, ,3)(0, ,3)(1, ,3)
    (0, ,4)(0, ,4)
    (1, ,5)(0, ,5)
    (1, ,6)
    (1, ,7)
    (1, ,8)
    (0, ,9)
    (1, ,10)

       */
      dp(value) = (dp(value)+1) % 2
    }
  }
  dp
}
//res4: Array[Int] = Array(0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0)
