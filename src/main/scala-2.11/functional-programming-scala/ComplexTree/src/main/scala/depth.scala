import edu.luc.cs.laufer.cs372.shapes._
import edu.luc.cs.laufer.cs372.shapes.Group
import edu.luc.cs.laufer.cs372.shapes.Location
import edu.luc.cs.laufer.cs372.shapes.Rectangle

object depth{

  def apply(s: Shape): Int = s match {

    case Rectangle(x, y) => 1

    case Ellipse(x, y) => 1

    case Location(x, y, shape) => 1+ depth(shape)

    case Group(children @ _*) => 1+ children.map(depth(_)).max

  }
}/*depth*/
