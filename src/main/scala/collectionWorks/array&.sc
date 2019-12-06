import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

val fiveInts = new Array[Int](5)
val fiveToOne = Array(5,4,3,2,1)
fiveInts(0) = fiveToOne(4)
fiveInts
//добавление в начало и конец за конст время
val buf = new ListBuffer[Int]
buf +=1
buf += 5
buf
3 +=: buf
buf.toList
buf.length
buf(0)

val buff = new ArrayBuffer[Int]()
buff +=3
buff +=5
buff
buff.length
buff(0)

//в Predef имеется подразумеваемое преобразование из String в StringOps

def hasUpperCase(s: String) = s.exists(_.isUpper)
hasUpperCase("asdfrE")
hasUpperCase("asdfr")