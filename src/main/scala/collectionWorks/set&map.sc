import scala.collection.mutable
//оступ предоставляется через объект
//  Predef , подразумеваемо импортируемый в каждый файл исходного кода

object Predef {
  type Map[A, +B] = collection.immutable.Map[A, B]
  type Set[A] = collection.immutable.Set[A]
  val Map = collection.immutable.Map
  val Set = collection.immutable.Set
  // ...
}
val mutaSet = mutable.Set(1, 2, 3)
val text = "See Spot run. Run, Spot. Run!"
val wordsArr = text.split("[ !,.]+")

val words = mutable.Set.empty[String]
for(word <- wordsArr)
  words += word.toLowerCase
words
val nums = Set(1,2,3)
nums + 5
nums -3
nums ++ List(1,2,3)
nums --List(1,2)
nums & Set(1,2)
nums.size
nums.contains(3)
words +="the"
words -="the"
words ++ List("qwe", "qwe")
words --List("do")
words.clear


val map = mutable.Map.empty[String, Int]
map("hello") = 1
map("world") = 2
map("hello")

def countWords(text: String) = {
  val counts = mutable.Map.empty[String, Int]
    for(rawWords <- text.split("[ ,!.]+")){
      val word = rawWords.toLowerCase //"hello"
      val oldCount =
        if(counts.contains(word)) counts(word)
        else 0

      counts += ( word -> (oldCount+1)) //добавляем в мапу ключ слово и значение+1,
                                      // записываем новое значение с этим ключом
    }
  counts
}
val cons = countWords("See Spot run! Run, Spot. Run!")

val maps = Map("i" -> 1, "rr"->2)
maps + ("vi"-> 6)
maps - "rr"
maps ++ List("aa"->1, "bb"->3)
maps.size
maps.contains("vi")
maps("rr")
maps.keys
maps.keys
maps.values
maps.isEmpty
 val wrds = mutable.Map.empty[String, Int]
wrds +=("asd" -> 1)
wrds -= ("asd")
wrds ++=List("asd" -> 1, "qwe"-> 2)
wrds --= List("one", "two")

import scala.collection.immutable.TreeSet
val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
val cs = TreeSet('f', 'u', 'n')

import scala.collection.immutable.TreeMap
var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
tm += (2 -> 'x')
tm

val people = Set("Nancy", "Jane")
//people += "Bob"   error

var peop = Set("Nancy", "Jane")
peop += "Bob"
peop
peop -= "Jane"
peop
peop ++= List("Tom", "Harry")
peop
var capital = Map("US" -> "Washington", "France" -> "Paris")
capital +=("Japan"-> "Tokyo")
capital
println(capital("France"))
//import scala.collection.mutable.Map

var roughlyPi = 3.0
roughlyPi+=0.1
roughlyPi += 0.04
roughlyPi

//компилятор Scala приступает в отношении этого объекта-спутника к преобразо-
//  ванию кода в вызов метода apply :
//  scala> List(1, 2, 3)
Set('a','b','c')
mutable.Map("a"-> 3, "e"->24)
Array(1.0, 2.0, 3.0)

val stuff = mutable.Set[Any](42)
val colors = List("blue", "yellow", "red", "green")
val treeSet = TreeSet[String]() ++ colors

treeSet.toList
treeSet.toArray

val mutset = mutable.Set.empty ++=treeSet
val immutSet = Set.empty ++ mutset

val mutmap = mutable.Map("i" -> 1, "ii" -> 2)
val immap = Map.empty ++ mutmap



