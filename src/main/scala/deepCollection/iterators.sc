//Операции в трейте Iterator page 502

val it= Iterator(1 to 10)
while (it.hasNext)
  println(it.next())
it foreach println
for (elem <- it)
  println(elem)

val itt = Iterator("a", "number", "of", "words")
val res1 = itt.map(_.length)
// res1  foreach println
val i = Iterator("a", "number", "of", "words")
i dropWhile (_.length > 2)
i
i.next
val (it1, it2) = i.duplicate

def skipEmptyWords(it: BufferedIterator[String]) =
  while (it.head.isEmpty) { it.next() }
val t = Iterator(1, 2, 3, 4)
val bit = t.buffered
bit.head
bit.next
bit.next
