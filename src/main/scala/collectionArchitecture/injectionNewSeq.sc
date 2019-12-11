
//нужно создать новый тип последовательности для РНК-нитей
//(RNA strands)  стр 516

abstract class Base
case object A extends Base //(аденина)
case object T extends Base //T (тимина)
case object G extends Base //G (гуанина)
case object U extends Base //(урацила)

object Base {
  val fromInt: Int => Base = Array(A, T, G, U)
  val toInt: Base => Int = Map(A -> 0, T -> 1, G -> 2, U -> 3)
}

//import collection.IndexedSeqLike
//import collection.mutable.{Builder, ArrayBuffer}
//import collection.generic.CanBuildFrom

final class RNA1 private (val groups: Array[Int], //упакованные RNA -данные
                            val length: Int) extends IndexedSeq[Base]{ //length , указывает общее количество
                                                             // оснований в массиве (и в последовательности)
  import RNA1._
  def apply(idx : Int) : Base = {
    if (idx < 0 ||length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }
}
object RNA1 {
  //колличество разрядов необходимое ддля представления группы
  private val S = 2
  // колличество групп перемещающееся в int значение
  private val N = 32/S
  //битовая маска для изоляции группы
  private val M = (1 << S) - 1
  //преобразует заданную последовательность оснований (то
  //есть значение типа Seq[Base] ) в экземпляр класса RNA1 .
  def fromSeq(buf: Seq[Base]): RNA1 = {
    val groups = new Array[Int]((buf.length + N-1)/ N)
    for(i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA1(groups, buf.length)
  }
  //получает изменяемое количество Base -аргументов
  //и переправляет эти аргументы в виде последовательности методу fromSeq
  def apply(bases: Base *)= fromSeq(bases)
}

val xs = List(A, G, T, A)
RNA1.fromSeq(xs)

val rna1 = RNA1(A, U, G, G, T)
rna1.length
rna1.last
rna1.take(3)
//def take(count: Int): RNA1 = RNA1.fromSeq(super.take(count))
//final class RNA2 private (
//                           val groups: Array[Int],
//                           val length: Int
//                         ) extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA2] {
//  import RNA2._
//  override def newBuilder: Builder[Base, RNA2] =
//    new ArrayBuffer[Base] mapResult fromSeq
//  def apply(idx: Int): Base = // as before
//}