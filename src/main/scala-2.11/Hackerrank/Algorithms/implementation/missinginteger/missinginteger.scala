package Hackerrank.Algorithms.implementation.missinginteger
/*
https://www.hackerrank.com/challenges/missing-numbers
Numeros, the Artist, had two lists  and , such that  was a permutation of . Numeros was very proud of these lists.
Unfortunately, while transporting them from one exhibition to another, some numbers were left out of .
Can you find the missing numbers?
Notes
If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same.
If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in  is less than or equal to .
------------------
Input Format
There will be four lines of input:
 - the size of the first list
This is followed by  space-separated integers that make up the first list.
 - the size of the second list
This is followed by  space-separated integers that make up the second list.
Constraints
Output Format
Output the missing numbers in ascending order.
Sample Input
10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output
204 205 206
Explanation

 is present in both arrays. Its frequency in  is , while its frequency in  is . Similarly,  and  occur twice in , but thrice in . So, these three numbers are our output. The rest of the numbers have thesame frequency in both lists.
 */

object missinginteger {

  def missingNumbers(a: Map[Int, Array[Int]], b: Map[Int, Array[Int]]): List[Int] = {

    (for (key <- b.keys;
          presentInA = a.isDefinedAt(key)
          if !presentInA || b(key).length > a(key).length) yield key
      ).toList.sorted
  }

  def main(args: Array[String]) {
    import java.util.Scanner
    val s = new Scanner(System.in)
    val A = s.nextInt()
    val list1 = (for (i <- 0 until A) yield s.next.toInt).toArray
    val B = s.nextInt()
    val list2 = (for (i <- 0 until B) yield s.next.toInt).toArray
    /**
      * Do not use toList will time out !!!!
      */

    val groupedByNumber1 = list1.groupBy(i => i)
    val groupedByNumber2 = list2.groupBy(i => i)
//    println(" groupedByNumber1",groupedByNumber1.toList)
//    println(" groupedByNumber2",groupedByNumber2.toList)
    println(missingNumbers(groupedByNumber1, groupedByNumber2).mkString(" "))
  }
}
/*
10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204

///
204 205 206

///
( groupedByNumber1,List((206,List(206, 206)), (205,List(205, 205)), (204,List(204, 204)), (208,List(208)), (203,List(203, 203)), (207,List(207))))
( groupedByNumber2,List((206,List(206, 206, 206)), (205,List(205, 205, 205)), (204,List(204, 204, 204)), (208,List(208)), (203,List(203, 203)), (207,List(207))))

 */