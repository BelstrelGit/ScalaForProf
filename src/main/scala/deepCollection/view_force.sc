
//def lazyMap[T, U](coll: Iterable[T], f: T =>U) =
//  new Iterable[U]{
////    def iterator = coll.iterator map f
//  }

//Представление является специализированным эквивалентом какой-либо основной
//  коллекции, где все преобразователи реализованы в ленивом варианте
//method view  обратно method force
val v = Vector(1 to 10: _ * )
//v map (_ + 1) map (_ * 2)
//(v.view map (_ + 1) map (_ * 2)).force
val vv = v.view
vv map (_ + 1)


def isPalindrome(x: String) = x == x.reverse
def findPalindrome(s: Seq[String]) = s find isPalindrome
val words = List("the", "quick", "brown", "fof")
findPalindrome(words take 1000000)
//findPalindrome(words.view take 1000000)

val arr = (0 to 9).toArray
val sub = arr.view.slice(3 , 6)
//sub: scala.collection.IndexedSeqView[Int] = IndexedSeqView(<not computed>)

def negate(xs: collection.mutable.Seq[Int]) =
  for (i <- 0 until xs.length)
        xs(i) = -xs(i)
//negate(sub)
arr

//val actors = for (i <- 1 to 10) yield actor { ... }
//val actors = (1 to 10) map (i => actor { ... })
//val actors = for (i <- (1 to 10).view) yield actor { ... }