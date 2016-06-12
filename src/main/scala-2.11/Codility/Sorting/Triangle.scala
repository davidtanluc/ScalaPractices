//https://codility.com/programmers/task/triangle/
val A = List(10, 2, 5, 1, 8, 20).sorted
//List(1, 2, 5, 8, 10, 20)
def solution(A: List[Int]): Int = {
  // println(A)
  for (i <- 0 until A.length - 2) {
    if (A(i) + A(i + 1) > A(i + 2) && A(i + 1) + A(i + 2) > A(i) && A(i + 2) + A(i) > A(i + 1)) {
      // println("sd", A(i), "ds", A(i + 1), " ", A(i + 2))
      return 1
    }
  }

  -1
}

//10, 50, 5, 1]
println("The number is :" + solution(A))
//List(1, 2, 5, 8, 10, 20)
//The number is :1
val B = List(6, 2, 5, 1, 8, 20).sorted
println("The number is :" + solution(B))
/*
List(1, 2, 5, 6, 8, 20)
(sd,2,ds,5, ,6)
The number is :1

 */
val C = List(3, 2, 5, 1, 8, 20).sorted
println("The number is :" + solution(C))
/*
List(1, 2, 3, 5, 8, 20)
The number is :-1

 */