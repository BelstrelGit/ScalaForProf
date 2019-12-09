val buf = collection.mutable.ArrayBuffer.empty[Int]
buf +=1
buf+=10
buf.toArray

val buff = collection.mutable.ListBuffer.empty[Int]
buff +=1
buff +=10
buff.toList

val b = new StringBuilder
b += 'a'
b ++= "z"
b ++="asdf"
b.toString()

val queue = new scala.collection.mutable.Queue[String]
queue += "a"
queue ++=List("a", "v", "f")
queue.dequeue
queue

val stack = new scala.collection.mutable.Stack[Int]
stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
stack
stack.top
stack
stack.pop
stack

val map = scala.collection.mutable.HashMap.empty[Int, String]
map += (1 -> "asdf")
map += (2 -> "af")
map(1)
map contains 3

//java.util.concurrent.ConcurrentMap ==> Scala.ConcurrentMap

val bits = scala.collection.mutable.BitSet.empty
bits+=1
bits+=2
bits+=3
bits

