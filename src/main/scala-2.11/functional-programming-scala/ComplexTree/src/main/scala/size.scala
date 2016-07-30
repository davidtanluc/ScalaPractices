import edu.luc.cs.laufer.cs372.shapes._
import edu.luc.cs.laufer.cs372.shapes.Group
import edu.luc.cs.laufer.cs372.shapes.Location
import edu.luc.cs.laufer.cs372.shapes.Rectangle

object size {

  def apply(s: Shape): Int = s match {

    case Rectangle(x, y) => 1

    case Ellipse(x, y) => 1

    case Location(x, y, shape) => size(shape)

    case Group(children @ _*) =>  children.map(size(_)).sum
    //case Group(s @ _*) =>  s.map(size(_)).sum /* pass*/
    //case g: Group => g.shape.map(size(_)).sum  /* fail!!*/

  }/*apply*/
}/*size*/