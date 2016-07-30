import edu.luc.cs.laufer.cs372.shapes.{Rectangle, TestFixtures, Shape}
import org.scalatest.FunSuite
import TestFixtures._

class TestSize extends FunSuite {

  def testSize(description: String, shape: Shape, s: Int) = {
    test(description) {  assert(s === size(shape))   }  }

  testSize("simple ellipse Size", simpleEllipse, 1)
  testSize("simple rectangle Size ", simpleRectangle, 1)
  testSize("simple location Size", simpleLocation, 1)
  testSize("basic group Size", basicGroup, 2)
  testSize("simple group Size", simpleGroup, 2)
  testSize("complex group Size", complexGroup, 5)

}/*Testsize*/