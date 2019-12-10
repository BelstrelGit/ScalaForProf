val str = "hello"
str.reverse         // ==> объект StringOps более высокий приоритет
str.map(_.toUpper)
str drop 3
str slice (1 , 4)
val seq : Seq[Char] = str  //WrappedString ==>immutable.IndexedSeq