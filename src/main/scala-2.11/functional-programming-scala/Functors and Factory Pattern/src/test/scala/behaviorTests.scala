package edu.luc.cs.cs372.team2.shapeAlgebraic

import org.scalatest.FunSuite
import scalaz.syntax.equal._
import scalaz.std.anyVal._ // for assert_=== to work on Int


class behaviorTests extends FunSuite {

  import scalamu.ToMuOps
  import scalamu.In
  import behaviors._
  import structures._

  import fixtures._

  test("boundingBox works") {
    simpleEllipse.cata(boundingBox) assert_=== In(Location(-50, -30, In(Rectangle(100, 60))))
    simpleRectangle cata boundingBox assert_===  In(Location(0, 0, In(Rectangle(80, 120))))
    simpleLocation cata boundingBox assert_=== In(Location(70, 30, In(Rectangle(80, 120))))
    basicGroup cata boundingBox assert_=== In(Location(-50, -30, In(Rectangle(100, 70))))
    simpleGroup cata boundingBox assert_=== In(Location(150, 50, In(Rectangle(350, 300))))
    complexGroup cata boundingBox assert_=== In(Location(30, 80, In(Rectangle(470, 300))))
  }

  test("scale works") {
    simpleEllipse cata scale(2) assert_=== In(Ellipse(100, 60))
    simpleRectangle cata scale(2) assert_=== In(Rectangle(160, 240))
    simpleLocation cata scale(2) assert_=== In(Location(140, 60, In(Rectangle(160, 240))))
    basicGroup cata scale(2) assert_=== In(Group(In(Ellipse(100, 60)), In(Rectangle(40, 80))))
    simpleGroup cata scale(2) assert_=== In(Group(
      In(Location(400, 200, In(Ellipse(100, 60)))),
      In(Location(800, 600, In(Rectangle(200, 100))))))

  }

  test("size works") {
    simpleEllipse cata size assert_=== 1
    simpleLocation cata size assert_=== 1
    basicGroup cata size assert_=== 2
    simpleGroup cata size assert_=== 2
    complexGroup cata size assert_=== 5
  }

  test("depth works") {
    simpleEllipse cata depth assert_=== 1
    simpleLocation cata depth assert_=== 2
    basicGroup cata depth assert_=== 2
    simpleGroup cata depth assert_=== 3
    complexGroup cata depth assert_=== 6
  }


}
