val a1 = Array(1,2,3,4,5)
val a2 = a1 map(_ *3)
val a3 = a2 filter (_ % 2 != 0)
a3.reverse
val seq: Seq[Int] = a1
val a4: Array[Int] = seq.toArray
a1 == a4 // in book TRUE

//val seq: Seq[Int] = a1
//seq.reverse
//
//val ops: collection.mutable.ArrayOps[Int] = a1
//ops.reverse
a1.reverse

import scala.reflect.ClassTag
def evenElems[T : ClassTag](xs: Vector[T]) : Array[T] = {
  val arr = new Array[T]((xs.length +1)/2)
  for (i <- 0 until xs.length by 2)
    arr(i/2) = xs(i)
  arr
}
evenElems(Vector(1, 2, 3, 4, 5))
evenElems(Vector("this", "is", "a", "test", "run"))

//def wrap[U](xs: Vector[U]) = evenElems(xs)
//Error:(26, 39) No ClassTag available for U
//def wrap[U](xs: Vector[U]) = evenElems(xs)

def wrap[U: ClassTag](xs: Vector[U]) = evenElems(xs)

