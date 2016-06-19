var A= Array(3,2,-6,4,0)

solution(A)
def solution(A:Array[Int]):Int ={
  if(A.isEmpty)return 0
  if(A.length ==1)return A.sum
  var max_ending =A.head
  var max_sum_slice =A.head

  for(elem <- A.tail){
    max_ending = elem max (elem + max_ending) // if elem if > or elem+max_ending use elem as lead, hence reset sum
    max_sum_slice = max_ending max max_sum_slice
  }

  max_sum_slice
}

//https://codility.com/demo/results/trainingMHJ4RZ-DEV/