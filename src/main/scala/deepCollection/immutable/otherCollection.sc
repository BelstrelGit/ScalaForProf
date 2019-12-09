val empty = scala.collection.immutable.Queue[Int]()
val has1 = empty.enqueue(1)
//val has2 = has1.enqueue(List(2,3,4,5))
//val (element, has23) = has2.dequeue

//Диапазоны
1 to 5
5 to 15 by 3
1 until 4

//Хеш-извлечения (hash-tries 1 )

//Красно-черные деревья
val set = collection.immutable.TreeSet.empty[Int]
set + 1 + 3 + 3

//Неизменяемые наборы битов
val bits = scala.collection.immutable.BitSet.empty
val moreBits = bits + 3 + 4 + 4
moreBits(3)
moreBits(0)

//Списочные отображения
val map = collection.immutable.ListMap(
  1 -> "one", 2 -> "two")
map(2)