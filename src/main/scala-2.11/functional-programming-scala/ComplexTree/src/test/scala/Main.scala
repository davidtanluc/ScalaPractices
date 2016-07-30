package edu.luc.cs.laufer.cs372.shapes
import TestFixtures._


object Main extends App {

  println(boundingBox(simpleEllipse))
  println(boundingBox(simpleRectangle))
  println(boundingBox(simpleLocation))
  println(boundingBox(complexGroup))

}
