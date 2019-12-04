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

