import scala.io.Source

val source = Source.fromFile("day1.txt", "UTF-8")
val lineIterator = source.getLines
for(l<- lineIterator){
  val ok1 = l.split("").toList
  val result = ok1.foldLeft(0)({
    case(acc,r)=>(acc,r)match{
      case(a,"(")=>acc+1
      case(a,")")=>acc-1
      case(a,_)=> acc
    }
  })
  println("result ",result)
}
