

def incAll(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => x + 1  :: incAll(xs1)
}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
def incAl(xs: List[Int]): List[Int] = {
val buf = new ListBuffer[Int]
for(x <- xs ) buf += x+1
buf.toList
}

//final override def map[U](f: T => U): List[U] = {
//  val b = new ListBuffer[U]
//  var these = this
//  while (!these.isEmpty) {
//    b += f(these.head)
//    these = these.tail
//  }
//  b.toList
//}

//package scala.collection.immutable.
//final class ListBuffer[T] extends mutable.Buffer[T] {
//  private var start: List[T] = Nil
//  private var last0: ::[T] = _
//  private var exported: Boolean = false
//}
//
//override def toList: List[T] = {
//  exported = !start.isEmpty
//  start
//}

//override def += (x: T) = {
//  if (exported) copy()
//  if (start.isEmpty) {
//    last0 = new scala.::(x, Nil)
//    start = last0
//  } else {
//    val last1 = last0
//    last0 = new scala.::(x, Nil)
//    last1.tl = last0
//  }
//}



