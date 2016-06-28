val A = Array(1,5,3,4,3,4,1,2,3,4,6,2)


solution(A)  //3


def solution(A:Array[Int]):Int={
  val N = A.length
  if(N < 3)return 0 // NONe
  if(N == 3){
    if(A(1)>A(0) && A(1)>A(2))return 1
    else return 0
  }
  val peaks = Array.fill(A.length)(0)
  for(i <- 1 until A.length -1){
    if(A(i)>A(i-1)&&A(i)>A(i+1))peaks(i)=1
  }
  ////List(0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0)
  def findMaximalFlags(n: Int): Boolean = {// find when cannot set flag
  var i = 0
    var flags = n  // 1,2,3,.....
    ///// trial error ///////
    while (flags > 0 && i < A.length) {
      if (peaks(i) == 1) {// @ 1,3,5,10
        flags -= 1
        i += n // skip by n  -->distance between any two flags should be greater than or equal to K
      } else i += 1 // go to next
    }

    flags == 0
  }
  var result = 1 // starts from 1
  while(true){
    if(!findMaximalFlags(result))return result -1
    result +=1
  }
  /// 4 cannot be maximum as it was previous result before true, hence minus 1//////
  result

}

//https://codility.com/demo/results/training92ZXXV-8VS/