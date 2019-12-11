
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
EMail.unapply("Belstrel@gmail.com")
EMail.unapply("Belstrel")
//selectorString match { case EMail(user, domain) => ... }
//               ==> EMail.unapply(selectorString)

//val x: Any = ...
//x match { case EMail(user, domain) => ... }
//EMail.unapply(EMail.apply(user, domain))

//
//EMail.unapply(obj) match {
//  case Some(u, d) => EMail.apply(u, d)
//}