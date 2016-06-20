/*
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
 */
val A = Array(0,1,0,1,1)
solution(A)
def solution(A:Array[Int]):Int ={

  if(A.indexWhere(_ == 1) == -1 || A.indexWhere(_ == 0) == -1)return 0 // all same direction

  val start_index = A.indexWhere(_ == 0)
  var passing_cars = 0
  var to_east = 0

  for(i <- start_index until A.length){
    if(A(i)==0)to_east += 1
    if(A(i)==1)passing_cars += to_east
    if(passing_cars >1000000000)return -1
  }

  passing_cars
}

//https://codility.com/demo/results/training7E2KYC-XA7/