import edu.luc.cs.laufer.cs372.shapes._
import edu.luc.cs.laufer.cs372.shapes.Group
import edu.luc.cs.laufer.cs372.shapes.Location
import edu.luc.cs.laufer.cs372.shapes.Rectangle

object scale{

  def apply(s: Shape, factor: Int): Shape = s match {

    case Rectangle(x, y) => Rectangle(factor*x, factor*y)

    case Ellipse(x, y) => Ellipse(factor*x, factor*y)

    case Location(x, y, shape) => Location(factor*x, factor*y, scale(shape, factor))

    case Group(children @ _*) =>  Group(children.map(scale(_, factor)):_*)

  }

}/*scale*/
