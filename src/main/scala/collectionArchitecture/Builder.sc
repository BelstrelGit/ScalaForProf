import scala.collection.mutable.ArrayBuffer
//package scala.collection.generic

//class Builder[-Elem, +To] {
//  def +=(elem: Elem): this.type
//  def result(): To
//  def clear()
//  def mapResult[NewTo](f: To => NewTo): Builder[Elem, NewTo]
////  = ...
//}
val buf = new ArrayBuffer[Int]
val bldr = buf mapResult(_.toArray)
