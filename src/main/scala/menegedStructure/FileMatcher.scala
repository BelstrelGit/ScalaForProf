package menegedStructure


//Когда в качестве аргумента используется функциональное зна-
//чение, особая часть алгоритма сама по себе является еще одним алгоритмом! При
//каждом вызове такой функции ей можно передавать в качестве аргумента другое
//функциональное значение, и функция по своему выбору вызывает переданное
//функциональное значение. Такие функции высшего порядка, то есть функции, полу-
//чающие другие функции в качестве параметров, обеспечивают вам дополнительные
//возможности по сокращению и упрощению кода.
object FileMatcher {

private def filesHere =
  (new java.io.File(".") ).listFiles()

  private def filesMatching(matcher : String => Boolean) =
    for(file <-filesHere
        if matcher(file.getName))
      yield file

  //  def filesEnding(query: String) =
//    for (file <- filesHere
//         if file.getName.endsWith(qeury)
//         ) yield file

  def filesEnding(query: String) =
//    filesMatching(query, _.endsWith(_))
  filesMatching(_.endsWith(query))
//                filename.endsWith(query)
  //  (fileName: String, query: String) => fileName.endsWith(query)

  def filesContaining(query: String) =
//    filesMatching(query, _.contains(_))
  filesMatching(_.contains(query))
//    for(file <- filesHere
//        if file.getName.contains(query))
//      yield file

  def filesRegex(query : String) =
    filesMatching(_.matches(query))
//    filesMatching(query, _.matches(_))

//  def filesMatching(query: String,
//                      matcher: (String, String) => Boolean) = {
//      for (file <- filesHere; if matcher(file.getName, query))
//        yield file
//    }
  def filesStartOf(query : String )=
  filesMatching(_.startsWith(query))


}
