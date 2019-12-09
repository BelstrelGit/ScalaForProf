import scala.collection.immutable.HashMap
import scala.collection.{LinearSeq, SortedSet, mutable}

Traversable(1, 2, 3)
Iterable("x", "y", "z")
Map("x" -> 24, "y" -> 25, "z" -> 26)
//Set(Color.Red, Color.Green, Color.Blue)
SortedSet("hello", "world")
//mutable.Buffer(x, y, z)
IndexedSeq(1.0, 2.0)
//LinearSeq(a, b, c)
// Полная иерархия коллекций стр 454

List(1, 2, 3)
HashMap("x" -> 24, "y" -> 25, "z" -> 26)
List(1, 2, 3) map (_ + 1)
Set(1, 2, 3) map (_ * 2)

val list = List(1,2,3,4,5)
val l = 5 :: list
val ll = l :+ 6
val lll = ll ::: List(1,2,3,4,5)
