object EMail {
  //метод вставки (не обязательный)
  //object EMail extends ((String, String) => String) { ... } Function2[String, String, String]
  def apply(user: String, domain: String) = //injection
    user +"@" + domain
  //метод извлечения(обязательный)
  def unapply(str: String): Option[(String, String)] = { //extractor
    val parts = str split "@"
    if (parts.length == 2)
      Some(parts(0), parts(1))
    else None

  }
}
object Twice{
  def apply(s: String): String = s+s
  def unapply(s: String): Option[String] ={
    val lengthHalf = s.length / 2
    val half = s.substring(0, lengthHalf)
    if( half == s.substring(lengthHalf))
              Some(half)
    else None
  }
}

object UpperCase{
  def unapply(s: String): Boolean = s.toUpperCase == s
}

def userTwiceUpper(s: String) = s match {
  case EMail(Twice(x @ UpperCase()), domain) =>
  "match: "+ x + " in domain "+ domain
  case _ => "no match"
}

userTwiceUpper("DIDI@hotmail.com")
userTwiceUpper("DIDO@hotmail.com")
userTwiceUpper("didi@hotmail.com")


