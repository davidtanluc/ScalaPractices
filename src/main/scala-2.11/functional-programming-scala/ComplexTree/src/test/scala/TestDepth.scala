import edu.luc.cs.laufer.cs372.shapes.{Rectangle, Shape, TestFixtures}
import org.scalatest.FunSuite
import TestFixtures._

class TestDepth extends FunSuite {

  def testDepth(description: String, shape: Shape, s: Int) = {
    test(description) {  assert(s === depth(shape))  } }

  testDepth("simple ellipse depth", simpleEllipse, 1)
  testDepth("simple rectangle depth", simpleRectangle, 1)
  testDepth("simple location depth", simpleLocation, 2)
  testDepth("basicGroup depth", basicGroup, 2)
  testDepth("simpleGroup depth", simpleGroup, 3)
  testDepth("complexGroup depth", complexGroup, 6)
}/*TestDepth*/

