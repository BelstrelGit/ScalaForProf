//List()
//List(x, y, _ * )
//Array(x, 0, 0, _)
 object List{
  def apply[T](elems: T * ) = elems.toList
  def unapplySeq[T](x: List[T]): Option[Seq[T]] = Some(x)
}
