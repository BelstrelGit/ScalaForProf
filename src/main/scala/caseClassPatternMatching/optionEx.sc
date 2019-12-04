

import scala.None

val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
capitals get "France"
capitals get "UA"

def show(x: Option[String]) = x match {
  case Some(s) => s
  case None => "?"
}
show(capitals get "Japan")
show(capitals get "North Pole")


val withDeafault : Option[Int] => Int = {
  case Some(x) => x
  case None => 0

}
withDeafault(Some(1))
withDeafault(None)


//var sum = 0
//def receive = {
//  case Data(byte) =>
//    sum += byte
//  case GetChecksum(requester) =>
//    val checksum = ~(sum & 0xFF) + 1
//    requester ! checksum
//}

val second: List[Int] => Int ={
  case x :: y :: z :: _ => z
}
second(List(1,2,3,4,5))
second(List())

val sec: PartialFunction[List[Int], Int] = {
  case x :: y :: _ => y
}

//sec.isDefinedAt(List(5,6,7))
//sec.isDefinedAt(List())
val d = new PartialFunction[List[Int], Int] {
  def apply(xs :List[Int]) = xs match {
    case x :: y :: _ => y
  }
  def isDefinedAt(xs : List[Int) = xs match {
    case x :: y :: _ => true
    case _ => false
  }
}

 for((country, city) <- capitals)
   println("The capital of " + country + " is " + city)
//for ((country, city) <- capitals)
//  println("The capital of " + country + " is " + city)
val results = List(Some("apple"), None,
  Some("orange"))

for (Some(fruit) <- results) println(fruit)
//apple
//orange