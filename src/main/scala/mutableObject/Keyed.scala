package mutableObject

class Keyed {
   def computedKey : Int = ???
}
class MemoKeyed extends Keyed {
  private var keyCache: Option[Int] = None
  override def computedKey: Int = {
  if(!keyCache.isDefined) keyCache =   Some(super.computedKey)
   keyCache.get
  }
}
