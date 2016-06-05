//https://codility.com/programmers/task/missing_integer/
def solution(xs:List[Int]):Int={
  val dict1 = xs.map(c => (c, 1)).groupBy(_._1).map(x => (x._1, x._2.length))

  val max = dict1.max._1
  val min = dict1.min._1
  val original_with_no_duplicate_sum = dict1.keys.sum
  ///// total of a number in series (n)(n+1)/2 =10*11/2 =55 ;;1+2+3+4+5+6+7+8+9+10 = 55////
  ///// val total sum should be ////
  var sum_series = 0
  for(i <- min to max) sum_series = sum_series + i
  sum_series - original_with_no_duplicate_sum //missing integer
}

println(solution(List(1, 3, 6, 4, 1, 2))) // 5