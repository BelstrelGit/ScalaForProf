//Экстракторы переменного количества аргументов

//dom match {
//  case Domain("org", "acm") => println("acm.org")
//  case Domain("com", "sun", "java") => println("java.sun.com")
//  case Domain("net", _ * ) => println("a .net domain")
//}

object EMail {
  //метод вставки (не обязательный)
  //object EMail extends ((String, String) => String) { ... } Function2[String, String, String]
  def apply(user: String, domain: String) = //injection
    user +"@" + domain
  //метод извлечения(обязательный)
  def unapply(str: String): Option[(String, String)] = { //extractor
    val parts = str split "@"
    if(parts.length == 2)
      Some(parts(0), parts(1))
    else None

  }
}

object Domain{
  def apply(parts: String * ): String =
    parts.reverse.mkString(".")
  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}

def isTomInDotCom(s: String): Boolean = s match {
  case EMail("tom", Domain("com", _ * )) => true
  case _ => false
}
isTomInDotCom("tom@sun.com")
isTomInDotCom("peter@sun.com")
isTomInDotCom("tom@acm.org")


object ExpandedEMail {
  def unapplySeq(email: String): Option[(String, Seq[String])]={
    val parts = email split "@"
    if(parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else None
  }
}
val s = "tom@support.epfl.ch"
val ExpandedEMail(name, topdom, subdoms @ _ * ) = s


