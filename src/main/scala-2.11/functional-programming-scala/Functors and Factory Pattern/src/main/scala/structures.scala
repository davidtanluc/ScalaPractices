package edu.luc.cs.cs372.team2.shapeAlgebraic

import scalaz.{ Equal, Functor, Show }
import scalamu._ // algebra types and injected cata method

/*
 * In this example, we represent arithmetic expressions as trees
 * (initial algebra for the endofunctor defined next).
 */

object structures {
  /**
   * Endofunctor for (nongeneric) F-algebra in the category Scala types.
   * Note that `A` is not a generic item type of the resulting algebraic
   * data type. As can be seen below, once we form `Shape` as the least
   * fixpoint of `ShapeF`, `A` will go away.
   *
   * @tparam A argument of the endofunctor
   */
  sealed trait ShapeF[+A]
  case class Rectangle(width: Int, height: Int) extends ShapeF[Nothing]
  case class Ellipse(a: Int, b: Int) extends ShapeF[Nothing]
  case class Location[A](x: Int, y: Int, shape: A) extends ShapeF[A]
  case class Group[A](children: A*) extends ShapeF[A]

  /**
   * Implicit value for declaring `ShapeF` as an instance of
   * typeclass `Functor` in scalaz.
   */
  implicit object ShapeFunctor extends Functor[ShapeF] {
    def map[A, B](fa: ShapeF[A])(f: A => B): ShapeF[B] = fa match {
      case Ellipse(a, b) => Ellipse(a, b)
      case Rectangle(w, h)   => Rectangle(w, h)
      case Location(x, y, s)  => Location (x, y, f(s))
      case Group(s @_*)  => Group(s.map(f(_)): _*)
    }
  }
  /**
   * Least fixpoint of `ShapeF` as carrier object for the initial algebra.
   */
  type Shape = µ[ShapeF]

  /* for assert_===  in behaviorTests later */
  implicit def ShapeFEqual[A]: Equal[ShapeF[A]] = Equal.equalA
  implicit def ShapeFShow[A]: Show[ShapeF[A]] = Show.showFromToString
  implicit val ShapeEqual: Equal[Shape] = Equal.equalA
  implicit val ShapeShow: Show[Shape] = Show.showFromToString

  /**
   * Factory for creating Shape instances.
   */
  object ShapeFactory {
    def ellipse(a: Int, b: Int): Shape = In(Ellipse(a, b))/* no error awaiting upgrades from Scalaz*/
    def rectangle(width: Int, height: Int): Shape = In(Rectangle(width, height))
    def location(x: Int, y: Int, shape: Shape): Shape = In(Location(x, y, shape))
    def group(s: Shape*): Shape = In(Group(s: _*))
  }
}