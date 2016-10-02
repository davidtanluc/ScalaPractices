def fastSolutionPython(A: Array[Int], B: Array[Int]): Array[Int] = {
  val N = A.length
  val M = B.length
  val size = A.max max B.max
  //println(size) //3
  val island = Array.fill(size + 2)(0)
  //println(island.toList)// List(0, 0, 0, 0, 0)

   // #N
  for (i <- 1 until N; if A(i - 1) > A(i)) {// previous greater than current
    island(A(i - 1)) += 1 //previous +1
    island(A(i)) -= 1 // current -1
  }

  //println(island.toList)//List(0, -1, 0, 1, 0)
  island(A(N - 1)) += 1
  //println(island.toList)//List(0, -1, 0, 2, 0)

   //# max(max(A), max(B)))
  for (i <- size to 0 by -1) island(i) += island(i + 1)
//  println(island.toList)//List(1, 1, 2, 2, 0)

  val result = Array.fill(M)(0)

  // #M
  for (i <- B.indices) result(i) = island(B(i) + 1)

  result


}
//List(1, 2, 2, 0, 2)
println(fastSolutionPython(Array(2, 1, 3, 2, 3), Array(0, 1, 2, 3, 1)).toList)

/*
100 % O(N + M + max(max(A), max(B)))

https://codility.com/demo/results/trainingFNCZ48-FXG/

============================================
Golden solution O(N + M + max(A) + max(B))
============================================

Imagine that the water level only decreases on consecutive days, and that on the first day
all the plots are under water, so there aren’t any islands. Next, we will investigate how the
number of islands changes depending on the water level. More precisely, we want to know
the value by which the number of islands increases or decreases if the water level decreases
to some level.

Each island has two sides (shores): left and right. Instead of counting the islands, we can
count their right sides. A position j is the right side of an island only if:

• Aj > Aj+1 (or j = N − 1),

• the water level is below Aj , but not below Aj+1.

So for every position j, such that Aj > Aj+1 (or j = N − 1), when the water level falls below
Aj the number of islands increases by one, but when it falls below Aj+1 it decreases by one.
For any water level, the number of islands is just the sum of changes in the number of
islands as the water level was decreasing.


We have the following number of islands on consecutive days:

on the first day there is only 1 island: (0, 4),
on the second day there are 2 islands: (0, 0) and (2, 4),
on the third day there are 2 islands: (2, 2) and (4, 4),
on the fourth day there aren't any islands,
on the fifth day there are 2 islands: (0, 0) and (2, 4).

*/