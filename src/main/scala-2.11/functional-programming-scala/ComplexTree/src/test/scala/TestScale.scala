import edu.luc.cs.laufer.cs372.shapes._
import edu.luc.cs.laufer.cs372.shapes.Ellipse
import edu.luc.cs.laufer.cs372.shapes.Rectangle
import org.scalatest.FunSuite
import TestFixtures._

class TestScale extends FunSuite {

  //def testScale1(description: String, f: Int) = {
    def testScale1(description: String, f: Int) = test(description){

    val expectedShape = Ellipse(150,90)
    val actualShape = scale(simpleEllipse, f).asInstanceOf[Ellipse]
    assert(actualShape.halfWidth === expectedShape.halfWidth)
    assert(actualShape.halfHeight === expectedShape.halfHeight)
  }

  def testScale2(description: String, f: Int) = test(description){

    val expectedShape = Rectangle(240,360)
    val actualShape = scale(simpleRectangle, f).asInstanceOf[Rectangle]
    assert(actualShape.height === expectedShape.height)
    assert(actualShape.width === expectedShape.width)
  }

  def testScale3(description: String, f: Int) = test(description){

    val actualShape = scale(simpleLocation, f).asInstanceOf[Location]
    assert(actualShape.x === 140)
    assert(actualShape.y === 60)
    assert(actualShape.shape.asInstanceOf[Rectangle].width === 160)
    assert(actualShape.shape.asInstanceOf[Rectangle].height === 240)

  }

  testScale1("simpleEllipse scale", 3)/* test-increase by a factor of 3 original Ellipse 50,30*/
  testScale2("simpleRectangle scale", 3)/* test-increase by a factor of 3 original Rectangle 80,120*/
  testScale3("simpleLocation scale", 2)/* test-increase by a factor of 2 original Location 70,30 ;Rectangle 80,120*/

}/*TestScale*/