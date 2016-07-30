package edu.luc.cs.laufer.cs372.shapes
/**
 * data Shape = Rectangle(w, h) | Location(x, y, Shape)
 */
sealed trait Shape

case class Ellipse(halfWidth: Int, halfHeight: Int) extends Shape

case class Rectangle(width: Int, height: Int) extends Shape

case class Location(x: Int, y: Int, shape: Shape) extends Shape { require(shape != null, "null shape in location")}

case class Group(children: Shape*) extends Shape {require(children != null, "null number of children")}


