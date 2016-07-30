package edu.luc.cs.cs372.team2.shapeAlgebraic

import org.scalatest.FunSuite
import scalaz.syntax.equal._
import scalaz.std.anyVal._
import scalamu._
class lawTests extends FunSuite {

  import structures._
  import structures.ShapeFactory._

  test("equality works") {
    (Ellipse(3, 2): ShapeF[Int]) assert_=== (Ellipse(3, 2): ShapeF[Int])
  }


}