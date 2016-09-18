import scala.collection.mutable
class Tree(var x: Int, var l: Tree, var r: Tree)


def solution(t: Tree): Int = {

  case class Tree2(var x: Int, var l: Tree, var r: Tree)
  implicit def toTree2(t: Tree): Tree2 = Tree2(t.x,t.l,t.r)

  def treeHeight(node: Tree): Int = {

    if (node == null) return 0
    val q = mutable.Queue[Tree]()
    q.enqueue(node)

    var height: Int = 0

    while (true) {

      var nodeCount: Int = q.size
      if (nodeCount == 0) return height //#end
      height += 1

      while (nodeCount > 0) {

        val newnode = q.dequeue()
        if (newnode.l != null) q.enqueue(newnode.l)
        if (newnode.r != null) q.enqueue(newnode.r)

        nodeCount -= 1
      }
    }
    //
    height
  }

  treeHeight(t) - 1
}

//// main //////////
val tree = new Tree(
  5,
  new Tree(3, new Tree(20, null, null), new Tree(21, null, null)),
  new Tree(10, new Tree(1, null, null), null)
)
solution(tree) //2
// 100 %
//https://codility.com/demo/results/training4J7DBQ-GB9/

/*
                          5
                        /   \
                      3      10
                    /   \    /  \
                   20    21  1
 */