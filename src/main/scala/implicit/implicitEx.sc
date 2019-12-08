implicit def doubleToInt(x: Double) = x.toInt

val i: Int = 3.5
//method  in Predef class - implicit import to all scala class
implicit def int2double(x: Int): Double = x.toDouble

//package scala
object Predef {
  class ArrowAssoc[A](x: A) {
    def -> [B](y: B): Tuple2[A, B] = Tuple2(x, y)
  }
  implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A] =
    new ArrowAssoc(x)

}