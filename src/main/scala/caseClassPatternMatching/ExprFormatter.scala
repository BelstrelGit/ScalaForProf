package caseClassPatternMatching

import compositionAndExtends.Element


//sealed - запечатанный класс. У такого запечатанного класса не может быть
//никаких добавленных подклассов, кроме тех, которые определены в том же самом
//файле. Особую пользу из этого можно извлечь при поиске по шаблону, поскольку
//запечатанность класса будет означать, что беспокоиться придется только по поводу
//тех подклассов, о которых вам уже известно. Более того, будет улучшена поддерж-
//ка со стороны компилятора. При поиске соответствий case-классам, являющимся
//наследниками запечатанного класса, компилятор в предупреждении отметит про-
//пущенные комбинации шаблонов.

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr


class ExprFormatter {

//Содержит операторы в группах с нарастающей приоритетностью
  private val opGroups =
    Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
    )
//отображение операторов на их степень приоритетности
  private val precedence = {
    val assocs =
      for {
        i <- 0 until opGroups.length
        op <- opGroups(i)
      } yield op -> i
    assocs.toMap
  }
  private val unaryPrecedence = opGroups.length
  private val fractionPrecedence = -1

  import compositionAndExtends.Element._

  private def format(e: Expr, enclPrec: Int): Element =
    e match {
      case Var(name) =>
        elem(name)

      case Number(num) =>
        def stripDot(s: String) =
          if (s endsWith ".0") s.substring(0, s.length - 2)
          else s
        elem(stripDot(num.toString))

      case UnOp(op, arg) =>
        elem(op) beside format(arg, unaryPrecedence)

      case BinOp("/", left, right) =>
        val top = format(left, fractionPrecedence)
        val bot = format(right, fractionPrecedence)
        val line = elem('-', top.width max bot.width, 1)
        val frac = top above line above bot
        if (enclPrec != fractionPrecedence) frac
        else elem(" ") beside frac beside elem(" ")

      case BinOp(op, left, right) =>
        val opPrec = precedence(op)
        val l = format(left, opPrec)
        val r = format(right, opPrec + 1)
        val oper = l beside elem(" " + op + " ") beside r
        if (enclPrec <= opPrec) oper
        else elem("(") beside oper beside elem(")")
    }
  def format(e: Expr): Element = format(e, 0)

}
