abstract class Expr
//toString , hashCode и equals copy
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr

val v = Var("x")
val op = BinOp( "+", Number(1.0), v )
v.name
op.left
println(op)
op.right == Var("x")
op.copy(operator = "-")



def simplifyTop(expr: Expr) : Expr = expr match{
  case UnOp("-",  UnOp( "-" , e )) => e //двойное отрицание
  case BinOp("+", e, Number(0)) => e //прибавление нуля
  case BinOp("*", e, Number(1.0)) => e //умнижение на единицу
  case _ => expr
}

def  describe(x: Any ) = x match{
  case 5 => "five"
  case true => "truth"
  case "hello"=> "hi"
  case Nil => "the empty list"
  case _ => "something else"
}

describe(5)
describe(6)
describe("hello")

//def describe(x: Any) = x match {
//  case 5 => "five"
//  case true => "truth"
//  case "hello" => "hi!"
//  case Nil => "the empty list"
//  case _ => "something else"
//}

//expr match {
//  case 0 => "zero"
//  case somethingElse => "not zero: " + somethingElse
//}

//import math.{E, Pi}
// E match {
//  case Pi => "strange math? Pi = " + Pi
//  case _ => "OK"
//}
//val pi = math.Pi
//pi: Double = 3.141592653589793
//scala> E match {
//  case pi => "strange math? Pi = " + pi
//}
//res12: String = strange math? Pi = 2.718281828459045

//поиск глубоких соответствий (deep matches).
//expr match {
//  case BinOp("+", e, Number(0)) => println("a deep match")
//  case _ =>
//}
//expr match {
//  case List(0, _*) => println("found it")
//  case _ =>
//}

def tupleDemo(expr: Any) = expr match {
  case (a,b,c) => println("matched" + a+b+c)
  case _ =>
}
tupleDemo(("a ", 3, "-tuple"))

//Типизированный шаблон (typed pattern)

def generalSize(x: Any) = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _ => -1
}
generalSize("asdf")
generalSize(Map(1 -> "asd", 2 -> "asdf"))
generalSize(5)

//if (x.isInstanceOf[String]) {
//  val s = x.asInstanceOf[String]
//  s.length
//} else ...

//scala> def isIntIntMap(x: Any) = x match {
//  case m: Map[Int, Int] => true
//  case _ => false
//}
//<console>:9: warning: non-variable type argument Int in type
//  pattern scala.collection.immutable.Map[Int,Int] (the
//  underlying of Map[Int,Int]) is unchecked since it is
//  eliminated by erasure
//  case m: Map[Int, Int] => true

def isStringArray(x: Any) = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}
isStringArray(Array("asdf"))
isStringArray(Array(3))

def varPat(x: Any) = x match {
  case UnOp("abs", e @ UnOp("abs", _)) => e
}
varPat("abs asdf  asf abs")

//ограничителя шаблонов (pattern guard).
def simplifyAdd(e: Expr) = e match {
  case BinOp("+", x, y ) if x==y =>
    BinOp("*", x, Number(2))
  case _ => e
//  case n: Int if 0 < n => ...
//  case s: String if s(0) == 'a' => ...
}

def simplifyAll(expr: Expr) : Expr = expr match {
  case UnOp("-", UnOp("-", e)) =>
    simplifyAll(e) // является собственной обратной величиной
  case BinOp("+", e, Number(0)) =>
    simplifyAll(e) //0 нейтральный элемент для "+"
  case BinOp("*", e, Number(1)) =>
    simplifyAll(e) // 1 нейтральный элемент для *
  case UnOp(op, e) =>
    UnOp(op, simplifyAll(e))
  case BinOp(op, l, r) =>
    BinOp(op, simplifyAll(l), simplifyAll(r))
  case _ => expr


}

//  case BinOp(op, l, r) =>
//    BinOp(op, simplifyAll(l), simplifyAll(r))
//  case _ => expr
//}

