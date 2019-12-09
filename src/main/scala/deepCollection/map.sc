def f(x: String) = {
  println("taking my time."); Thread.sleep(100)
  x.reverse }
val cache = collection.mutable.Map[String, String]()
//def cachedF(s: String) = cache.getOrElseUpdate(s, f(s))


def cachedF(arg: String) = cache get arg match {
  case Some(result) => result
  case None =>
    val result = f(arg)
    cache(arg) = result
    result
}
cachedF("abc")
cachedF("abc")