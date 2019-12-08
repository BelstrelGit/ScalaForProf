trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract{
  type T = String
  def transform(x: String) = x+x
  val initial: String = "hi"
  var current= initial
}


trait AbstractTime {
  def minute : Int
  def minute_=(x: Int)
  def hour : Int
  def hour_=(x: Int)
}

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
}
new RationalTrait { //экземпляр безымянного класса
  val numerArg = 1
  val denomArg = 2
}

//предварительно проинициализированные поля
//ведут себя в этом смысле подобно аргументам конструктора класса
object twoThirds extends {
  val numerArg = 2
  val denomArg = 3
} with RationalTrait

//class RationalClass(n: Int, d: Int) extends {
//  val numerArg = n
//  val denomArg = d } with RationalTrait {
//  def + (that: RationalClass) = new RationalClass(
//    numer * that.denom + that.numer * denom,
//    denom * that.denom
//  )
//}

//Ленивые val-переменные
object Demo {
  lazy val x = { println("initializing x"); "done" }
}
trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = numer + "/" +  denom
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

val x = 2
new LazyRationalTrait {
  val numerArg = 1 * x
  val denomArg = 2 * x
}

class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}
class Grass extends Food
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) = {}
}

val bessy: Animal = new Cow
//тип зависящим от пути (path-dependent type)
//bessy.SuitableFood
//Animal{ type SuitableFood = Grass } //Уточняющие типы
//
//class Pasture {
//  var animals: List[Animal {type SuitableFood = Grass}] = Nil
//}





