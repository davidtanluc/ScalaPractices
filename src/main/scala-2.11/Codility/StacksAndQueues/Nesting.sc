//https://codility.com/demo/results/trainingS8P9X9-TAH/


def solution(S:String):Int ={
  if(S.isEmpty) return 1


  import scala.annotation.tailrec
  @tailrec
  def loop(S: List[Char], countopener: Int):Int = S match {
    case Nil if countopener == 0 => 1
    case Nil if countopener > 0 => 0  // not balance
    case '('::tail => loop(tail, countopener + 1)
    case ')'::tail if countopener > 0 => loop(tail, countopener - 1)
    case ')'::tail if countopener == 0 => 0
    case(xs1)=>loop(xs1.tail,countopener)//skip non paren
  }
  loop(S.toList, 0)

}

val str1 ="(()(())())"
//solution(str1)
val str2 = "())"
val str3 = ""
solution(str3)