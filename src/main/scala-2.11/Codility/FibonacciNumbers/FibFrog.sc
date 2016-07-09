def prn(x: TraversableOnce[_]) = println(x.mkString(x.getClass.getSimpleName + "(", ", ", ")"))


solution(Array(0,0,0,1,1,0,1,0,0,0,0))//3 pass
def solution(A:Array[Int]):Int ={
  val n: Int = A.length //11
  val fib = Array.fill(26)(0)
  lazy val fibs: Stream[Int] = 0 #:: fibs.scan(1)(_ + _)
  for (i<-2 until 26)fib(i) = fibs(i)
  val dp = Array.fill(n+1)(-1)
  //////////////////
  for (i<-0 to n) {
    if (!(i < n && A(i) == 0)){
      import java.util
      if (util.Arrays.binarySearch(fib, i + 1) >= 0) {
        dp(i) = 1
      }else{
        loop1()
        ////// helper //////
        def loop1(): Unit ={
          for (j<-1 until 26) {
            ///// find previous fibonacci number ////
            if (i - fib(j) < 0)return //if previous is smaller out of this
            ////////////////////////////////
            if (dp(i - fib(j)) != -1){ // adjacent  position not -ve 1
              if (dp(i) == -1) dp(i) = dp(i - fib(j)) + 1
              else dp(i) = dp(i) min dp(i - fib(j)) + 1
            }
          }
        }

      }
    }

  }//for
  //prn(dp)//ofInt(-1, -1, -1, -1, 1, -1, 2, -1, -1, -1, -1, 3)
  dp(n)

}

//https://codility.com/demo/results/training2WMPM9-KZA/