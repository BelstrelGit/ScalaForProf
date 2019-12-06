//Под операторами высшего порядка понимаются функции высшего порядка, использу-
//  емые в системе записи операторов.  функция относится
//  к высшему порядку, если получает в качестве параметров одну функцию и более.

//получает в качестве операндов список xs типа List[T] и функ-
//  цию f типа T => UList(1,2,3) map (_ +1)
val words = List("the", "quick", "brown", "fox")
words map (_ .length )
words map (_ .toList.reverse.mkString)

//в качестве правого операнда получает функ-
//  цию, возвращающую список элементов
words map (_ .toList)
words flatMap (_.toList)

val l = List.range(1, 5)
l flatMap (
  i => List.range(1, i)
    map (j => (i, j))
  )

for (i <- List.range(1, 5);
     j <- List.range(1, i)) //1,1
        yield (i, j)
val a =Range(1,1)
val b =Range(1,2)

//foreach получает в качестве правого операнда процедуру
//(функцию, результатом которой является тип Unit )
var sum = 0
List(1,2,3,4,5) foreach (sum += _)
sum