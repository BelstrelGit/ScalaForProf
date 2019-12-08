

abstract class Fruit
class Apple extends Fruit
class Orange extends Fruit

val apples = new Apple :: Nil
val fruits = new Orange :: apples

//def ::[U >: T](x: U): List[U] = new scala.::(x, this)

//def :::[U >: T](prefix: List[U]): List[U] =
//  if (prefix.isEmpty) this
//  else prefix.head :: prefix.tail ::: this

//prefix.head :: prefix.tail ::: this
//является эквивалентом (поскольку :: и ::: обладают правой ассоциативностью):
//  prefix.head :: (prefix.tail ::: this)
//является эквивалентом (поскольку :: привязывается к правому операнду):
//  (prefix.tail ::: this).::(prefix.head)
//является эквивалентом (поскольку ::: привязывается к правому операнду):
//  this.:::(prefix.tail).::(prefix.head)



//final case class ::[U](hd: U,
//            private[scala] var tl: List[U]) extends List[U] {
//  def head = hd
//  def tail = tl
//  override def isEmpty: Boolean = false
//}















//final case ::[T](hd: T, tl: List[T]) extends  List[T]{
//def head = hd
//def tail = tl
//override def isEmpty: Boolean = false
//}

//final case class ::[T](head: T, tail: List[T])
//  extends List[T] {
//  override def isEmpty: Boolean = false
//}
//
//def length: Int =
//  if (isEmpty) 0 else 1 + tail.length
//
//def drop(n: Int): List[T] =
//  if (isEmpty) Nil
//  else if (n <= 0) this
//  else tail.drop(n - 1)
//
//def map[U](f: T => U): List[U] =
//  if (isEmpty) Nil
//  else f(head) :: tail.map(f)
















