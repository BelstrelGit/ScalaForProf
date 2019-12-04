def  isEquals(x: Int, y : Int ): Boolean={
  return x == y
}
isEquals(222, 222)

val x = "asd"
val y = "asd"
x==y
x.equals(y)
x.eq(y)

val xx = new String("asd")
val yy = new String("asd")

xx == yy
xx.eq(yy)
xx.equals(yy)

class Dollars(val amount : Int) extends AnyVal {
  override def toString() = "$" + amount
}

//класс значений
val money = new Dollars(100)
money.amount




class Anchor(val value : String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value : String) extends AnyVal

def title(text: Text, anchor: Anchor, style:Style) : Html =
  new Html(
    s"< a id = '${anchor.value}'>" +
    s"h1 class = '${style.value}'"+
    text.value+
      "</h1></a>"
  )

//ошибка
//title(new Anchor("chap:vcls"), new Style("bold"),
//  new Text("Value Classes"))



