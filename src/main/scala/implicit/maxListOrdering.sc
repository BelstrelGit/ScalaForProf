
def maxListOrdering[T](elements: List[T])
                      (ordering: Ordering[T]): T =
  elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListOrdering(rest)(ordering)
         if (ordering.gt(x, maxRest)) x
      else  maxRest
  }

def maxListImpParm[T](elements: List[T])
                     (implicit ordering: Ordering[T]): T =
  elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListImpParm(rest)(ordering)
      if (ordering.gt(x, maxRest)) x
      else maxRest
  }

maxListImpParm(List(1,5,10,3))
maxListImpParm(List(1.5, 5.2, 10.7, 3.14159))
maxListImpParm(List("one", "two", "three")) //why??