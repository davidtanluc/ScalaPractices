package edu.luc.cs.laufer.cs372.shapes
import edu.luc.cs.laufer.cs372.shapes._

object boundingBox {

  def apply(s: Shape): Location = s match {

    case Rectangle(_, _) =>
      new Location(0, 0, s)
    case Location(x, y, shape) => {
      val b = boundingBox(shape)
      Location(x + b.x, y + b.y, b.shape)
    }

    case Ellipse(m ,k) =>
      new Location(-m, -k, new Rectangle(2*m, 2*k))
    case Group(shapes @ _*) =>
      val shaper = List(shapes:_*)
      def xVal(w: Location): Int = {
        return w.x
      }
      def yVal(w: Location): Int = {
        return w.y
      }
      def rightPts(w: Location): Int = {
        return w.x + w.shape.asInstanceOf[Rectangle].width
      }
      def highPts(w: Location): Int = {
        return w.y + w.shape.asInstanceOf[Rectangle].height
      }
      val q = shaper map (z => boundingBox(z))
      val minX = q.reduceLeft((s1,s2) =>  if (xVal(s2) < xVal(s1)) s2 else s1).x
      val minY = q.reduceLeft((s1,s2) =>  if (yVal(s2) < yVal(s1)) s2 else s1).y

      val maxX = rightPts(q.reduceLeft((s1,s2) =>  if (rightPts(s2) > rightPts(s1)) s2 else s1))
      val maxY = highPts(q.reduceLeft((s1,s2) =>  if (highPts(s2) > highPts(s1)) s2 else s1))

      val wid = (maxX-minX).abs
      val hei = (maxY-minY).abs
      new Location(minX, minY, new Rectangle(wid, hei))

  }
}/*end boundingBox*/



