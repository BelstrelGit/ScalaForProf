def append[T](xs: List[T], ys: List[T]) : List[T] =
  xs match{
    case List() => ys
    case x :: xs1 => x :: append(xs1,  ys)
  }

//def rev[T](xs: List[T]): List[T] = xs match {
//  case List() => xs
//  case x :: xs1 => rev(xs1) ::: List(x)
//}
//head tail O, константное время -> last init On надо обойти весь список
def rev[T](xs: List[T]): List[T] = xs match{
  case List() =>  xs
  case x :: xs1 => rev(xs1) ::: List(x)
}
//drop, take и splitAt
val abcde = List('a', 'b', 'c', 'd', 'e')
abcde.reverse
abcde take 2  //все элементы n
abcde drop 2 // все элементы за исключением 2
abcde splitAt(2) //разделяет по заданному индексу

//apply и indices
abcde apply 2 // по индексу
abcde(2)
abcde.drop(2).head

abcde.indices
 List(List(1,2), List(3,4)).flatten

abcde.indices zip abcde
//элементы без пару отбрасываются
val zipped = abcde.zipWithIndex
zipped.unzip
abcde.toString()
abcde.mkString("1 ", "|", "post")
//pre + xs(0) + sep + ...+ sep + xs(xs.length - 1) + post
//xs mkString sep   -> xs mkString ("", sep, "")
//xs.mkString  -> xs mkString ""
abcde mkString ("[", ",", "]")
abcde mkString ""
abcde.mkString
abcde mkString ("List(", ", ", ")")

val buf = new StringBuilder
abcde addString (buf, "(", ";", ")")

//mkString и addString наследуются из родительского трейта Traversable
//  класса List , поэтому их можно применять ко всем другим коллекциям

//Преобразование списков: iterator, toArray, copyToArray

val arr = abcde.toArray
arr.toList
//xs copyToArray (arr, start)
val arr2 = new Array[Int](10)
List(1,2,3) copyToArray (arr2, 3)
arr2
val it = abcde.iterator
it.next
it.next


val x = List(1,2):::List(3,4,5)
//def isort(xs: List[Int]): List[Int] =
//  if(xs.isEmpty) Nil
//  else insert(xs.head, isort(xs.tail))
//
//def insert(x: Int, xs: List[Int]) : List[Int] =
//  if(xs.isEmpty || x<= xs.head) x :: xs
//  else xs.head :: insert(x, xs.tail)

val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
//усредненная вычислительная сложность пропорциональ-
//на квадрату длины входящего списка
//def isort(xs: List[Int]): List[Int] = xs match {
//  case List()
//  => List()
//  case x :: xs1 => insert(x, isort(xs1))
//}
//def insert(x: Int, xs: List[Int]): List[Int] = xs match {
//  case List() => List(x)
//  case y :: ys => if (x <= y) x :: xs
//  else y :: insert(x, ys)
//}

