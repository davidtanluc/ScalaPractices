//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
//53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103,
//val x1 = sieve(25).zipWithIndex.filter(_._1).map(y=>y._2)
val x2 = sieve(100).zipWithIndex.filter(_._1).map(y=>y._2)


def sieve(n:Int):Array[Boolean]={//true = unmark
  val sieveArr = Array.fill(n+1)(true)
  sieveArr(0) = false
  sieveArr(1) = false

  var i = 2

  while(i*i <=n){
    var k = 2 //start
    var tmp = k * i
    while(tmp<=n){
      if(sieveArr(tmp)){//remove multiples
        sieveArr(tmp)= false
      }
      k+=1
      tmp = k*i
    }
    i +=1
  }
  sieveArr
}

