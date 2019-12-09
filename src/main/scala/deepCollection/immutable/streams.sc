val str = 1 #:: 2 #:: 3 #:: LazyList.empty
//val str = 1 #:: 2 #:: 3 #:: Stream.empty

def fibFrom(a: Int, b: Int) : LazyList[Int] =
  a #:: fibFrom(b, a+ b)

val fibs = fibFrom(1, 1).take(7)
fibs.toList

