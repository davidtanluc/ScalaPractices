//Refer to : https://codility.com/programmers/task/brackets/
import scala.annotation.tailrec

val closer = Map("}"->"{",")"->"(","]"->"[")
val opener =Set("{","(","[")

def solution(xs:List[String]):Int={
  val n = xs.size
  if(n==0)return 1

  @tailrec
  def loop1(next:Int,result:(List[String],Int)):(List[String],Int) = {
    if(result._2 == 0)return (List(),0) //end
    if(next ==n)return result//end

    val ch = xs(next)
    val tmp = result match{
        case res if opener.contains(ch) => (ch::res._1, res._2)
        case (x::xs1,tf) if closer.contains(ch) && closer(ch) == x => (xs1, 1) //true match remove one opener
        case (x::xs1,tf) if closer.contains(ch) && closer(ch) != x => (xs1, 0) //false end
        case (res,tf) if closer.contains(ch) && res.isEmpty => (res, 0) //false end
        case (res,tf) => (res, tf) //skip if non closer nor opener
      }
    loop1(next+1,tmp)
  }
  ////////////////////
  loop1(0,(List(),1))._2
}

println(solution("".split("").toList))//1
println(solution("{{{}}}".split("").toList))//1
println(solution("{[()()]}".split("").toList))//1
println(solution("([)()]".split("").toList))//0
println(solution("{{{{{}}}}}(((((((S)c)a)l)a)i){s}[C](o((o))L){}[]}".split("").toList))//0
println(solution("{{{{{{}}}}}(((((((S)c)a)l)a)i){s}[C](o((o))L){}[]}".split("").toList))//0
println(solution("{(((((((S)c)a)l)a)i))}".split("").toList))//1
println(solution("{{{{{{}}}}}(((((((S)c)a)l)a))i){s}[C](o((o))L){}[]}".split("").toList))//1
