/*
https://www.hackerrank.com/challenges/utopian-tree

The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height.
Each summer, its height increases by 1 meter.

Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of spring. How tall
 will her tree be after growth cycles?

Input Format

The first line contains an integer, the number of test cases.

 subsequent lines each contain an integer,
 denoting the number of cycles for that test case.

Constraints


Output Format

For each test case, print the height of the Utopian Tree after  cycles.
Each height must be printed on a new line.


/////////////////////////
Sample Input

3
0
1
4
Sample Output

1
2
7
Explanation

There are 3 test cases.

In the first case (), the initial height () of the tree remains unchanged.

In the second case (), the tree doubles in height and is  meters tall after the spring cycle.

In the third case (), the tree doubles its height in spring (), then grows a meter in summer (),
then doubles after the next spring (), and grows another meter after summer (). Thus, at the end of 4 cycles,
its height is  meters.


 */

solution(1, 1, 0) //1
solution(1, 1, 1) //2
solution(1, 1, 2) //3
solution(1, 1, 3) //6
solution(1, 1, 4) //7
solution(1, 1, 7) //30
def solution(springHeight: Int, summer: Int, N: Int): Int = {
  if (N == 0) return springHeight
  var result = springHeight

  for (i <- 1 to N) {

    i % 2 match {
      case (0) => result += summer //even 2,4,6
      case (_) => result = 2 * result
    }

  }

  result
}
//solutionByFormula(0) //1
//solutionByFormula(1) //2
//solutionByFormula(3) //6
//solutionByFormula(4) //7
//solutionByFormula(5) //14
def solutionByFormula(N: Int): Int = {
  if (N == 0) return 1
  if (N == 1) return 2

  if (N % 2 == 1) Math.pow(2, (N + 1) / 2 + 1).toInt - 2

  else Math.pow(2, N / 2 + 1).toInt - 1
}
solutionByFormula2(0) //1
solutionByFormula2(1) //2
solutionByFormula2(3) //6
solutionByFormula2(4) //7
solutionByFormula2(5) //14
def solutionByFormula2(N: Int): Int = N match {

    case 0 => 1

    case 1 => 2

    case x if x % 2 == 1 => 2 * Math.pow(2, (N + 1) / 2).toInt - 2 //3,5,7

    case y if y % 2 == 0 => 2 * Math.pow(2, N / 2).toInt - 1 //4,6,8

  }

//https://www.hackerrank.com/challenges/utopian-tree/submissions/code/28676145

def solutionByFormula3(N: Int): Int = N match {

  case 0 => 1

  case 1 => 2

  case x if x % 2 == 1 => 2 * Math.pow(2, (N + 1) / 2).toInt - 2 //3,5,7

  case y if y % 2 == 0 => 2 * Math.pow(2, N / 2).toInt - 1 //4,6,8

}

def main(args: Array[String]) {
  val sc = new java.util.Scanner(System.in)
  val t = sc.nextInt()
  var a0 = 0
  while (a0 < t) {
    val n = sc.nextInt()
    println(solutionByFormula3(n))
    a0 += 1
  }
}

/*
------------------------------
 Derive the above formula
 ------------------------------

 original spring h - 1
 summer - 1

 Cycles        Height
  0             1
  1             2 * h
  2             2 * h + 1(summer)
  3             2 * (2 +1 ) ---> Odd = 2*(2^(n+1)/2 -1) = 2 * (2^(n+1)/2) -2
  4             2(2+1) +1    ---> Even = 2*(2^(n+1)/2 -1) + 1 = 2 * (2^(n+1)/2) -1
  ....

 */