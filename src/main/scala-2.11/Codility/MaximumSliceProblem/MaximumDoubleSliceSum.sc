//https://en.wikipedia.org/wiki/Maximum_subarray_problem
val A = Array(3,2,6,-1,4,5,-1,2)
solution(A)
def solution(A:Array[Int]):Int={
    val maximum_subarray = (acc:Int,elem:Int)=> 0 max (elem + acc)

    val middle_list = A.init.tail /// remove head and last

    val from_left_to_right = 0 +: middle_list.scan(0)(maximum_subarray)
    val from_right_to_left = middle_list.scanRight(0)(maximum_subarray) :+ 0
    //  println(from_left_to_right)
    //  println(from_right_to_left)
    /*
  List(0,  0,  2, 8, 7, 11, 16, 15)
  List(16, 14, 8, 9, 5, 0,   0, 0)
     */
    var maximum_double_slice_sum = 0

    for(i <- 1 until A.length - 1){
      maximum_double_slice_sum = maximum_double_slice_sum max
        (from_left_to_right(i)+from_right_to_left(i))

    }

    maximum_double_slice_sum

}

//https://codility.com/demo/results/trainingD8TE5X-P2B/