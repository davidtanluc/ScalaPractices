//https://codility.com/media/train/15-DynamicProgramming.pdf

/*
frog jump
1,3 --> 6
111111
1113
33 --> 3
 */
solution(List(1,3),6,2)//Array(1, 1, 1, 2, 2, 2, 3)
//solution(List(1,3,5,10,25),100,2)//
/*
res0: Array[Int] = Array(1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 8, 9, 10, 12, 13, 16, 18, 19, 22,
24, 28, 31, 33, 37, 40, 46, 50, 53, 59, 63, 71, 77, 81, 89, 95, 105, 113, 119, 129, 137, 150,
160, 168, 181, 191, 207, 220, 230, 246, 259, 279, 295, 308, 328, 344, 368, 388, 404, 428, 448,
477, 501, 521, 550, 574, 608, 637, 661, 695, 724, 764, 798, 827, 867, 901, 948, 988, 1022,
1069, 1109, 1163, 1210, 1250, 1304, 1351, 1413, 1467, 1514, 1576, 1630, 1701, 1763, 1817, 1888,
1950, 2030, 2101, 2163, 2243, 2314, 2405)
solution: solution[](val jumps: List[Int],val distance: Int,val modulo: Int) => Array[Int]


 */
//solution(List())
def solution(jumps:List[Int],distance:Int,modulo:Int)={

  val ways = new Array[Int](distance+1)


  ways(0) = 1
  for(jump_size <- jumps){//1,3 distance 6
    for(from_jump_size_to_distance <-jump_size to distance){
      //println("JUMP",j)
      ways(from_jump_size_to_distance) +=ways(from_jump_size_to_distance-jump_size)// % modulo
//      println(ways.toList)
      /*
List(1, 1, 0, 0, 0, 0, 0)
List(1, 1, 1, 0, 0, 0, 0)
List(1, 1, 1, 1, 0, 0, 0)
List(1, 1, 1, 1, 1, 0, 0)
List(1, 1, 1, 1, 1, 1, 0)
List(1, 1, 1, 1, 1, 1, 1)
List(1, 1, 1, 2, 1, 1, 1)
List(1, 1, 1, 2, 2, 1, 1)
List(1, 1, 1, 2, 2, 2, 1)
List(1, 1, 1, 2, 2, 2, 3)
       */
    }
  }
  //println(ways.toList)
  ways
}