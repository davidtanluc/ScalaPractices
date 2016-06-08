def Solution(S: String): Int = {
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
//https://codility.com/demo/results/trainingQWV9PA-VND/
///// test cases ///
Solution("([)()]") // 0
Solution("{[()()]}") //1