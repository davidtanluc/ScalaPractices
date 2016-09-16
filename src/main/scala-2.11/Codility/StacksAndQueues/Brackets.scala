def solution(S: String): Int = {
  if (S.isEmpty) return 1 //balance
  val xs = S.split("").toList

  val out = xs.foldLeft(List[String]())({

    (acc,r)=>(acc,r) match{
      ///// load////
      case(ys1,"{")=> "{"::ys1
      case(ys1,"(")=> "("::ys1
      case(ys1,"[")=> "["::ys1

      //// unload /////
      case(ys1,"}")=>if(ys1.nonEmpty && ys1.head == "{") ys1.tail else return 0//notbalance
      case(ys1,")")=>if(ys1.nonEmpty && ys1.head == "(") ys1.tail else return 0//notbalance
      case(ys1,"]")=>if(ys1.nonEmpty && ys1.head == "[") ys1.tail else return 0//notbalance

      ///skip //////
      case(ys1,_)=>ys1
    }
  })

  if(out.nonEmpty)return 0 //not balance
  1 //balance

}
// 100 %
//https://codility.com/demo/results/trainingWFJG5C-89S/
///// test cases ///
solution("([)()]") // 0
solution("{[()()]}") //1