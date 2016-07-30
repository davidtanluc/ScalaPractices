package edu.luc.cs.cs372.team2.shapeAlgebraic

object behaviors {

  import scalamu._
  import scalamu.Algebra
  import structures._

  // specific ShapeF-algebras: note nonrecursive nature

  def size: Algebra[ShapeF, Int] = {
    case Rectangle(_, _) => 1
    case Ellipse(_, _) => 1
    case Location(_, _, s) => s
    case Group(s @_*) => s.sum
  }

  def depth: Algebra[ShapeF, Int] = {
    case Rectangle(_, _) => 1
    case Ellipse(_, _) => 1
    case Location(_, _, s) => s + 1
    case Group(s @_*) => s.max + 1
  }

  def scale(fctr: Int): Algebra[ShapeF, Shape] = {
    case Rectangle(w, h)   => In(Rectangle(w*fctr, h*fctr))
    case Ellipse(a, b)     => In(Ellipse(a*fctr, b*fctr))
    case Location(x, y, s) => {
      In(Location(x * fctr, y * fctr, s))
    }
    case Group(s @_*)      => In(Group(s: _*))
  }

  val boundingBox: Algebra[ShapeF, Shape]  = {
    case Rectangle(w, h) => In(Location(0, 0, In(Rectangle(w, h))))
    case Ellipse(a, b) => In(Location(-a, -b, In(Rectangle(2*a, 2*b))))
    case Location(x, y, s) => {
      val b = s match { case In(Location(x_, y_, s_)) => Location(x_, y_, s_)}
      In(Location(x+b.x, y+b.x, In(b.shape.out)))
    }
    case Group(s @_*) => {
      s.reduceLeft((r_, e_) => {
        val r = r_ match { case In(Location(x_, y_, s_)) => Location(x_, y_, s_) }
        val e = e_ match { case In(Location(x_, y_, s_)) => Location(x_, y_, s_) }
        val r1 = r.shape match { case In(Rectangle(w_, h_)) => Rectangle(w_, h_) }
        val r2 = e.shape match { case In(Rectangle(w_, h_)) => Rectangle(w_, h_) }
        val width = getMax(r.x, r.x+r1.width, e.x, e.x+r2.width) - getMin(r.x, r.x+r1.width, e.x, e.x+r2.width)
        val height = getMax(r.y, r.y+r1.height, e.y, e.y+r2.height) - getMin(r.y, r.y+r1.height, e.y, e.y+r2.height)
        In(Location(r.x.min(e.x), r.y.min(e.y), In(Rectangle(width, height))))
      })
    }
  }
  def getMax(nums: Int*): Int = { nums.max }
  def getMin(nums: Int*): Int = { nums.min }

}