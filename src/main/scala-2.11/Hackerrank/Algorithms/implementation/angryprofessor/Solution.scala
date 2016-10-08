package Hackerrank.Algorithms.implementation.angryprofessor

/**
  * Created by davidtan on 10/7/16.
  */

/*

https://www.hackerrank.com/challenges/angry-professor

A Discrete Mathematics professor has a class of  students. Frustrated with their lack of discipline, he decides to cancel class if fewer than  students are present when class starts.

Given the arrival time of each student, determine if the class is canceled.

Input Format

The first line of input contains , the number of test cases.

Each test case consists of two lines. The first line has two space-separated integers,  (students in the class) and (the cancelation threshold). The second line contains  space-separated integers () describing the arrival times for each student.

Note: Non-positive arrival times () indicate the student arrived early or on time; positive arrival times () indicate the student arrived  minutes late.

Constraints

Output Format

For each test case, print the word YES if the class is canceled or NO if it is not.

Note
If a student arrives exactly on time , the student is considered to have entered before the class started.

Sample Input

2
4 3
-1 -3 4 2
4 2
0 -1 2 1
Sample Output

YES
NO
Explanation

For the first test case, . The professor wants at least  students in attendance, but only  have arrived on time ( and ). Thus, the class is canceled.

For the second test case, . The professor wants at least  students in attendance, and there are  who have arrived on time ( and ). Thus, the class is not canceled.


 */
object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val t = sc.nextInt()
    var a0 = 0

    while (a0 < t) {
      val n = sc.nextInt();
      val k = sc.nextInt();
      // threshold
      val a = new Array[Int](n)
      for (a_i <- 0 to n - 1) {
        a(a_i) = sc.nextInt();
      }
      val num_students = a.toList.count(_ < 1)
      /// if cancel print yes else no
      if (num_students >= k) println("NO") else println("YES")
      a0 += 1
    }//while

  }
}

/*
2
4 3
-1 -3 4 2
4 2
0 -1 2 1


Sample Output

YES
NO


 */