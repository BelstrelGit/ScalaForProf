object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}
object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}
//object Color extends Enumeration {
//  val Red, Green, Blue = Value
//}
import Color._
//object Direction extends Enumeration {
//  val North, East, South, West = Value
//}
object Direction extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}
for (dir <- Direction.values) println(dir)
Direction.East.id
Direction(1)