/////

val sample = Seq(1, 4, 5, 6, 77, 89, 0)
val elem = 77 // none
binarySearch(sample,elem)//4
def binarySearch[A](xs:Seq[A],target:A)(implicit ord:Ordering[A]):Option[Int]={
  var (left,right) =(0,xs.length-1)

  while(left<=right){
    (left + right)/2 match {
      case mid if ord.lt(xs(mid),target) => left = mid + 1
      case mid if ord.gt(xs(mid),target) => right = mid - 1
      case mid  => return Some(mid)
    }

  }
  None

}