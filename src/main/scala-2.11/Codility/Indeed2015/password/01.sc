/*
- it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
- there should be an even number of letters;
- there should be an odd number of digits.

 */
def solution(s: String) :Int= {
  // write your code in Scala 2.11
  val tokens = s.split(" ").filter(
    "[^a-z^0-9^A-Z]".r findFirstIn _ match {
      case Some(_) => false
      case None => true

    })

  def numberAndLetter(s:String): Boolean = isDigitOdd(s) && isLetterEven(s)

  def isDigitOdd(s:String):Boolean = {
    val n = s.filter(_.isDigit).length
    n % 2 != 0
  }

  def isLetterEven(s:String) :Boolean= {
    val n  = s.filterNot(_.isDigit).length
    n % 2 == 0
  }

  val l= tokens.filter(numberAndLetter)
  if(l.isEmpty)return -1
  (for(el <- l.toList; n = el.length) yield if(n<1)-1 else n).max

}
// 100 %
//https://codility.com/demo/results/training9JXFTP-YH5/
solution("test 5 a0A pass007 ?xy1") //7
solution("??** archoooo11 brup 1p2p0") //7
solution("??** archoooo11 brup") //7
solution("??** archoooo11 brup 1") //1
solution("??** archoooo11 brup a") //-1