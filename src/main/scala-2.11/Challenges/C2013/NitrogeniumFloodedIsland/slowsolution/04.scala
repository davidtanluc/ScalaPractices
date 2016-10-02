/*
    3      ----     -----
    2---   |   |----|   |
     | |   |            |
   1 |  ---             |
    0|                  |
 */
val A = Array(2, 1, 3, 2, 3)
val B = Array(0, 1, 2, 3, 1)
println(solution(A, B).toList) //Array(1, 2, 2, 0, 2)
def solution(A: Array[Int], B: Array[Int]) = {
  val last_A = A.length - 1

  /*
    What is an island
    1) if current > water level and is the last value A count 1
    2) if current > water level and nextA, A(i+1) is <= water level count 1
   */
  for (water_level <- B) yield {

    val positions = for (i <- A.indices;
                         currentA = A(i)
                         if currentA > water_level && (i == last_A || A(i + 1) <= water_level)) yield i
   // println(positions)
    /*
Vector(4)
Vector(0, 4)
Vector(2, 4)
Vector()
Vector(0, 4)
     */
    positions.size
  }


}

/*
on the first day there is only 1 island: (0, 4),
on the second day there are 2 islands: (0, 0) and (2, 4),
on the third day there are 2 islands: (2, 2) and (4, 4),
on the fourth day there aren't any islands,
on the fifth day there are 2 islands: (0, 0) and (2, 4).

 */