/*


 */
arrayF(20).zipWithIndex.filter(_._1 != 0)
//res0: Array[(Int, Int)] =
// Array((2,4), (2,6), (2,8),
// (3,9), (2,10), (2,12), (2,14), (3,15),
// (2,16), (2,18),
// (2,20))
def arrayF(n:Int):Array[Int]={
  val F = Array.fill(n+1)(0)
  //println(F.toList)
  var i = 2

  ///////////////////
  while(i*i<=n){
    var k = 2 //start
    var tmp = k * i
      while(tmp<=n){
        //println("#",k)
        if(F(tmp)==0){
          F(tmp) = i
        }
        k +=1
        tmp = k*i
      }
    i +=1
  }
  F
} ///????
/*
def factorization(x, F):
2 primeFactors = []
3 while (F[x] > 0):
4 primeFactors += [F[x]]
5 x /= F[x]
6 primeFactors += [x]
7 return primeFactors

 */

//def factorization(x:Int,F:Array[Int])={
//  val primeFactors = Array.fill(x+1)(0)
//  var i = 0
//  while(F(x)>0){
//    primeFactors
//  }
//
//  //????
//  1
//}