//import scala.collection.immutable.TreeSeqMap.Builder
//import scala.collection.mutable.ArrayBuffer
//
//abstract class Base
//case object A extends Base //(аденина)
//case object T extends Base //T (тимина)
//case object G extends Base //G (гуанина)
//case object U extends Base //(урацила)
//
//object Base {
//  val fromInt: Int => Base = Array(A, T, G, U)
//  val toInt: Base => Int = Map(A -> 0, T -> 1, G -> 2, U -> 3)
//}
////import collection.IndexedSeqLike
//final class RNA private (val groups: Array[Int], val length: Int)
//  extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA] {  //import collection.IndexedSeqLike не найдено
//  import RNA._
//  //обязательное создание новой реализации newBuilder  в IndexedSeq
//  override protected[this] def newBuilder: Builder[Base, RNA] =
//    RNA.newBuilder
//  //обязательная реалицзация apply  в IndexSeq
//  def apply(idx: Int): Base = {
//    if (idx < 0 || length <= idx)
//      throw new IndexOutOfBoundsException
//    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
//  }
//  //необязательное создание новой реализации foreach для повышения эффективности работы
//  override def foreach[U](f: Base => U): Unit = {
//    var i = 0
//    var b = 0
//    while (i < length) {
//      b = if (i % N == 0) groups(i / N) else b >>> S
//      f(Base.fromInt(b & M))
//      i += 1
//    }
//  }
//}
//
//object RNA {
//  //колличество разрядов необходимое ддля представления группы
//  private val S = 2
//  // колличество групп перемещающееся в int значение
//  private val N = 32/S
//  //битовая маска для изоляции группы
//  private val M = (1 << S) - 1
//  def fromSeq(buf: Seq[Base]): RNA = {
//    val groups = new Array[Int]((buf.length + N - 1) / N)
//    for (i <- 0 until buf.length)
//      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
//    new RNA(groups, buf.length)
//  }
//  def apply(bases: Base * ) = fromSeq(bases)
//  def newBuilder: Builder[Base, RNA] =
//    new ArrayBuffer mapResult fromSeq
//  implicit def canBuildFrom: CanBuildFrom[RNA, Base, RNA] =
//    new CanBuildFrom[RNA, Base, RNA] {
//      def apply(): Builder[Base, RNA] = newBuilder
//      def apply(from: RNA): Builder[Base, RNA] = newBuilder
//    }
//}