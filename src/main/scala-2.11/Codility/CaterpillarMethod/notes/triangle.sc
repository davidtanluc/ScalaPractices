/*
15.2. Exercise
Problem: You are given n sticks (of lengths 1 ˛ a0 ˛ a1 ˛ ... ˛ an≠1 ˛ 109). The goal is
to count the number of triangles that can be constructed using these sticks. More precisely,
we have to count the number of triplets at indices x<y<z, such that ax + ay > az.
Solution O(n2): For every pair x, y we can find the largest stick z that can be used to
construct the triangle. Every stick k, such that y<k ˛ z, can also be used, because the
condition ax + ay > ak will still be true. We can add up all these triangles at once.
If the value z is found every time from the beginning then we get a O(n3) time complexity
solution. However, we can instead use the caterpillar method. When increasing the value of
y, we can increase (as far as possible) the value of z


 */

def triangles(A: Array[Int]): Int = {
  val n = A.length
  var result = 0
  for (x <- 0 until n) {
    var z = x + 2
    for (y <- 0 until x + 1 by n) {
      while (z < n && A(x) + A(y) > A(z)) {
        z += 1
      }
      result += z - y - 1
    }
  }
  result
}