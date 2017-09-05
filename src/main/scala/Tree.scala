

trait Tree
case class Node(children: Tree*) extends Tree
case class Leaf(terminals: Set[Int]) extends Tree


object Tree extends Tree {


  def of(tree: Tree): Tree = tree

  def intersect(tree: Tree): Set[Int] = {
    tree match {
      case Leaf(a)      => a
      case Node(a @ _*) => a map { x => intersect(x) } reduce ((left, right) => left.intersect(right))
    }
  }


  implicit class RichIntersect( tree: Tree){
    def intersect : Set[Int] = Tree.intersect(tree)
  }


}


