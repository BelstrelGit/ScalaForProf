//Фильтрация списков: filter, partition, find, takeWhile,
//dropWhile и span
List(1,2,3,4,5) filter (_ % 2 == 0 )

//partition возвращает пару списков true fals
//xs partition p  == (xs filter p, xs filter (!p(_)))
List(1,2,3,4,5) partition (_ %2 == 0)

//find  возвращает только первый элемент, удовлетворяющий условию заданного предиката
List(1,2,3,4,5) find (_ %2 == 0)
List(1,2,3,4,5) find (_ == 10)

//Операторы takeWhile и dropWhile также получают в качестве правого операнда
//  предикат. Операция xs takeWhile p получает самый длинный префикс списка xs ,
//в котором каждый элемент удовлетворяет условию предиката p . Аналогично этому
//  операция xs dropWhile p удаляет самый длинный префикс из списка xs , в котором
//  каждый элемент удовлетворяет условию предиката p .
val words = List("the", "quick", "brown", "fox")
words dropWhile (_ startsWith "t")
List(1, 2, 3, -4, 5) takeWhile (_ > 0)

//Метод span объединяет takeWhile и dropWhile в одну операцию точно так же,
//как метод splitAt объединяет stake и drop . Он возвращает пару из двух списков,
//определяемых следующим эквивалентом:
//  xs span p  ==  (xs takeWhile p, xs dropWhile p)
List(1, 2, 3, -4, 5) span (_ > 0)

//есть ли в матрице, представленной списком списков, строка, состоящая только из
//нулевых элементов,
def hasZeroRow(m: List[List[Int]]) =
  m exists (row => row forall (_ == 0))
//forall  true если все элементы удовлетворяют предикату
//exists если один элемент удовлетворяет предикату

//sum(List(a, b, c))  == 0 + a + b + c
def sum(xs: List[Int]): Int = (0 /: xs) (_ + _)
//product(List(a, b, c))  == 1 * a * b * c
def product(xs: List[Int]): Int = (1 /: xs) (_ * _)

//(z /: List(a, b, c)) (op)  == op(op(op(z, a), b), c)

//("" /: words) (_ + " " + _)
//(words.head /: words.tail) (_ + " " + _)

//def flattenLeft[T](xss: List[List[T]]) =
//  (List[T]() /: xss) (_ ::: _)
//def flattenRight[T](xss: List[List[T]]) =
//  (xss :~List[T]()) (_ ::: _)

List(1, -3, 4, 2, 6) sortWith (_ < _)
words sortWith (_.length > _.length)