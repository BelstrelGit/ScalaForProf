case class Book(title: String, authors: String * )

val books: List[Book] =
  List(
    Book(
      "Structure and Interpretation of Computer Programs",
    ),
    Book(
      "Principles of Compiler Design",
    ),
    Book(
      "Programming in Modula-2",
      "Wirth, Niklaus"
    ),
    Book(
      "Elements of ML Programming",
      "Ulman, Jefri"
    ),
    Book("The Java Language Specification",
      "Gosling , James "
    )
  )
for(b <-books;
    a<- b.authors
    if a startsWith( "Gosling"))
  yield b.title

for (b <- books
     if(b.title indexOf "Program") >= 0)
  yield b.title

for(b1 <- books;
    b2 <- books
    if b1!=b2;
    a1 <- b1.authors;
    a2 <- b2.authors
    if a1==a2) yield a1

def removeDuplicates[A](xs: List[A]): List[A] = {
  if(xs.isEmpty) xs
  else xs.head :: removeDuplicates(
    xs.tail filter (x => x != xs.head)
  )
}

def removeDuplicates1[A](xs: List[A]): List[A] = {
  if(xs.isEmpty) xs
  else xs.head :: removeDuplicates1(
   for(x <- xs.tail if  x != xs.head) yield x
  )
}
removeDuplicates1(List(1,2,3,3,5,6))

//«найти имена всех авторов написавших хотя бы две книги»:
for(b1 <- books;
    b2 <- books
    if b1!= b2 ;
    a1 <- b1.authors;
    a2 <- b2.authors
    if a1==a2) yield a1
// транслируется в
books flatMap (b1 =>
  books withFilter (b2 => b1 != b2) flatMap (b2 =>
    b1.authors flatMap (a1 =>
      b2.authors withFilter (a2 => a1 == a2) map (a2 =>
        a1))))






