//for ( x <- expr1 ) yield expr2   ===>  expr1 .map( x => expr2 )
//
//for ( x <- expr 1 if expr 2 ) yield expr 3  ===> for ( x <- expr 1 withFilter ( x => expr 2 )) yield expr 3
//               ===>
//expr 1 withFilter ( x => expr 2 ) map ( x => expr 3 )
//
//for ( x <- expr 1 if expr 2 ; seq) yield expr 3 ===> for ( x <- expr 1 withFilter expr 2 ; seq) yield expr 3


//for (pat <- expr 1 ) yield expr 2
// транслируется в
//expr 1 withFilter {
//  case pat => true
//  case _ => false
//} map {
//  case pat => expr 2
//}

  //for (x <- 1 to 1000;
  //     y = expensiveComputationNotInvolvingX)
  //  yield x * y
  //// лучше
  //val y = expensiveComputationNotInvolvingX
  //for (x <- 1 to 1000) yield x * y

//выражение суммирует все элементы матрицы,
//представленной в виде списка списков:
//var sum = 0
//for (xs <- xss;
//     x <- xs) sum += x
//var sum = 0
//xss foreach (xs =>
//  xs foreach (x =>
//    sum += x))

object Demo {
  def map[A, B](xs: List[A], f: A => B): List[B] =
    for (x <- xs)
      yield f(x)
  def flatMap[A, B](xs: List[A], f: A => List[B]): List[B] =
    for (x <- xs;
         y <- f(x)) yield y
  def filter[A](xs: List[A], p: A => Boolean): List[A] =
    for (x <- xs
         if p(x)) yield x }