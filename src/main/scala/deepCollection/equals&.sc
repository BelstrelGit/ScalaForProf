import scala.collection.immutable.{HashSet, TreeSet}
import collection.mutable.{HashMap, ArrayBuffer}


List(1, 2, 3) == Vector(1, 2, 3)
HashSet(1, 2) == TreeSet(2, 1)

val buf = ArrayBuffer(1, 2, 3)
val map = HashMap(buf -> 3)
map(buf)
buf(0)+=1
map(buf)