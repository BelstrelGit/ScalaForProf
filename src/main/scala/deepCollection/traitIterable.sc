//def foreach[U](f: Elem => U): Unit = {
//  val it = iterator
//  while (it.hasNext)
//    f(it.next())
//}
val xs = List(1, 2, 3, 4, 5)
val git = xs grouped 3
git.next
git.next
val sit = xs sliding 3
sit.next()
sit.next()
sit.next()
xs.zipWithIndex


//sealed abstract class Tree extends Traversable[Int] {
//  def foreach[U](f: Int => U) = this match {
//    case Node(elem) => f(elem)
//    case Branch(l, r) => l foreach f; r foreach f
//  }
//}
//sealed abstract class Tree extends Iterable[Int] {
//  def iterator: Iterator[Int] = this match {
//    case Node(elem) => Iterator.single(elem)
//    case Branch(l, r) => l.iterator ++ r.iterator
//  }
//}
//
//case class Branch(left: Tree, right: Tree) extends Tree
//case class Node(elem: Int) extends Tree

Seq(1,2,3)(1)== 2
Set('a', 'b', 'c')('b') == true
Map('a' -> 1, 'b' -> 10, 'c' -> 100)
('b') == 10 














