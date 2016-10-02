import java.util
import java.util.PriorityQueue

case class City(var id:Int, a:Int, var max:Int = -1) extends Ordered[City]{
  var children = new java.util.LinkedList[City]
  var parent:City = null

  if(id!=0 || a!=0)max = a

  def compare(that: City): Int = {
    if (that.a != this.a) {that.a - this.a}
    else {that.max - this.max}
  }

  override def toString: String = "id:" + id + " a:" + a
}
//////////////////////////////////////////////
import scala.collection.JavaConversions._

def buildTree(root: City, visited: Array[Boolean]) {

  val st = new java.util.Stack[City]
  st.add(root)

  while (!st.isEmpty) {

    if (visited(st.peek.id)) {

      val current = st.pop

      for (c <- current.children
           if c != current.parent) current.max = Math.max(current.max, c.max)

    }
    else {

      val current = st.peek
      visited(current.id) = true

      for (c <- current.children
           if !visited(c.id)) {

          c.parent = current
          st.add(c)
      }
      //
    }
  }
  //
}

def largestClusterCity(maxValue: Int, cityMap: Array[City]): City = {

  var largest: City = null
  val visited = new Array[Boolean](cityMap.length)
  var maxSize = 0

  for (i<- cityMap.indices;
       current: City = cityMap(i)
       if !visited(current.id) && current.a == maxValue;
       size = largestCluster(maxValue, current, visited)
       if size > maxSize) {

        maxSize = size
        largest = current

  }

  largest
}

def largestCluster(maxValue: Int, current: City, visited: Array[Boolean]): Int = {

  visited(current.id) = true

  var count = 1

  if (current.a != maxValue) return 0

  val children = current.children

  for (c <- children
       if !visited(c.id)) count += largestCluster(maxValue, c, visited)

  count
}

def find(x: City, included: Array[Boolean], explored: PriorityQueue[City],
         unExplored: PriorityQueue[City], max: Int): Int = {

  var min = x.a
  var count = 1
  if (count > max) return -1
  val needed = new util.HashSet[City]()
  included(x.id) = true
  needed.add(x)

  while (!unExplored.isEmpty && unExplored.peek.a > min) {
    var current: City = unExplored.remove
    while (!included(current.id)) {

      included(current.id) = true
      needed.add(current)
      current = current.parent

      min = min min current.a
      count += 1

      if (count > max) return -1

    }
  }

  for (c <- needed;
       children = c.children;
       child <- children
       if !included(child.id))  explored.add(child)


  count
}
////

def solution(k: Int, c: Array[Int], d: Array[Int]): Int = {
  val cityMap = new Array[City](c.length)
  val explored = new PriorityQueue[City]()
  val unExplored = new PriorityQueue[City]()
  var max: City = null

  for (i <- c.indices) {

    if (cityMap(i) == null) {

      cityMap(i) = City(i,d(i))

      if (max == null) max = cityMap(i) else max = if (cityMap(i).a > max.a) cityMap(i) else max
    }
    ////
    if (c(i) != i) {

      if (cityMap(c(i)) == null) {

        cityMap(c(i)) = City(c(i), d(c(i)))

        if (max == null) max = cityMap(c(i))
        else max = if (cityMap(c(i)).a > max.a) cityMap(c(i)) else max
      }

      cityMap(i).children.add(cityMap(c(i)))
      cityMap(c(i)).children.add(cityMap(i))
    }

  }
  ////

  val largest: City = largestClusterCity(max.a, cityMap)
  buildTree(largest, new Array[Boolean](c.length))
  var count: Int = 0
  val included = new Array[Boolean](c.length)

  for (c <- cityMap) unExplored.add(c)

  explored.add(largest)

  var result = 0
  while (!explored.isEmpty && result != -1) {

    val current: City = explored.remove

    if (!included(current.id)) {
      result = find(current, included, explored, unExplored, k - count)

      if (result != -1) {
        count = count + result
      }
    }
  }

  count
}

//val K = 2
//val K = 3
//val K = 4
//val  K = 5
//val  K = 2
val C  = Array(1,3,0,3,2,4,4)
val D  = Array(6,2,7,5,6,5,2)

for(i<- 0 to 10)println("i:",i," ",solution(i,C,D))
//https://codility.com/demo/results/training74PDR9-M4E/
/*
(i:,0, ,0)
(i:,1, ,1)
(i:,2, ,2)
(i:,3, ,3)
(i:,4, ,4)
(i:,5, ,4)
(i:,6, ,6)
(i:,7, ,7)
(i:,8, ,7)
(i:,9, ,7)
(i:,10, ,7)

 */