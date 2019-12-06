(1, "hello", Console)
//Поскольку кортежи могут сочетать объекты различных типов, они не являются на-
//  следниками класса Traversable


def longestWord(words: Array[String]) = {
  var word = words(0)
  var idx = 0
  for (i <- 1 until words.length)
    if (words(i).length > word.length) {
      word = words(i)
      idx = i
    }
  (word, idx)
}
val longest =
  longestWord("The quick brown fox".split(" "))

longest._1
val (word, idx) = longest
word

//val word, idx = longest
