/*
    3      ----     -----
    2---   |   |----|   |
     | |   |            |
     |  ---             |
    0|                  |

 */


val A = Array(2, 1, 3, 2, 3)
val B = Array(0, 1, 2, 3, 1) //water level

def solution(A: Array[Int], B: Array[Int]) = B map
  (water => A
    .zipWithIndex
    //,List(List((3,4)), List((2,0), (3,4)), List((3,2), (3,4)), List(), List((2,0), (3,4))))
    .filter(y => (y._1 > water) && (y._2 == A.length - 1 || A(y._2 + 1) <= water))
    //List(List(1), List(1, 1), List(1, 1), List(), List(1, 1)))
    .map(c => 1)
    //,List(1, 2, 2, 0, 2))
    .count(_ == 1)
    )
println("FINAL ", solution(A, B).toList)
//(FINAL ,List(1, 2, 2, 0, 2))
//https://codility.com/demo/results/trainingVR2Y2W-9A7/