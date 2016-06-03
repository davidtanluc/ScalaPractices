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
    val tmp = (result, xs(next)) match{
      case (res,ch) if opener.contains(ch) => ((ch::res._1,res._2),ch)
      case ((x::xs1,tf),ch )if closer.contains(ch) && closer(ch) == x => ((xs1,1),ch) //true match
      case ((x::xs1,tf),ch )if closer.contains(ch) && closer(ch) != x => ((xs1,0),ch) //false end
      case ((res,tf),ch )if closer.contains(ch) && res.isEmpty => ((res,0),ch) //false end
      case ((res,tf),ch ) => ((res,tf),ch) //skip non closer or opener
    }
    loop1(next+1,tmp._1)
  }
  ////////////////////
  loop1(0,(List(),1))._2
}

//solution("{{{}}}".split("").toList)//1
//solution("{[()()]}".split("").toList)//1
//solution("([)()]".split("").toList)//0
solution("{{{{{}}}}}(((((((S)c)a)l)a)i){s}[C](o((o))L){}[]".split("").toList)//1

//https://codility.com/programmers/task/brackets/