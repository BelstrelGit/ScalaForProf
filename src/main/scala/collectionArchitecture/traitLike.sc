

//trait TraversableLike[+Elem, +Repr] {
//  def newBuilder: mutable.Builder[Elem, Repr] // deferred
//  def foreach[U](f: Elem => U) // deferred
//  ...
//  def filter(p: Elem => Boolean): Repr = {
//    val b = newBuilder
//    foreach { elem => if (p(elem)) b += elem }
//    b.result
//  }
//}
import collection.immutable.BitSet
import scala.collection.mutable

val bits = BitSet(1, 2, 3)
bits map (_ * 2)
bits map (_.toFloat)
Map("a" -> 1, "b" -> 2) map { case (x, y) => (y, x) }
Map("a" -> 1, "b" -> 2) map { case (x, y) => y }

import scala.collection.generic.CanBuildFrom
//def map[B, That](f: Elem => B)
//                (implicit bf: CanBuildFrom[Repr, B, That]): That = {
//  val b = bf(this)
//  for (x <- this) b += f(x)
//  b.result
//}

import scala.collection.generic
trait CanBuildFrom[-From, -Elem, +To] {
  //create new Builder
  def apply(from: From): mutable.Builder[Elem, To]
}

//CanBuildFrom[Set[_], A, Set[A]]

val xs: Iterable[Int] = List(1, 2, 3)
val ys = xs map (x => x*x)
